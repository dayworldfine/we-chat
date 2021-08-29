package cn.chat.server.service.impl;

import cn.chat.server.pojo.info.ChatRecordInfo;
import cn.chat.server.pojo.info.TalkBoxInfo;
import cn.chat.server.pojo.info.UserFriendInfo;
import cn.chat.server.pojo.info.UserInfo;
import cn.chat.server.pojo.model.user.GroupsInfo;
import cn.chat.server.pojo.model.user.LuckUserInfo;
import cn.chat.server.service.UserService;
import cn.chat.server.repository.UserRepository;
import cn.chat.server.pojo.entity.UserFriend;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    //默认线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);


    @Override
    public boolean checkAuth(String userId, String userPassword) {
        // 简单比对验证
        String authCode = userRepository.queryUserPassword(userId);
        return userPassword.equals(authCode);
    }

    @Override
    public UserInfo queryUserInfo(String userId) {
        return userRepository.queryUserInfo(userId);
    }

    @Override
    public List<TalkBoxInfo> queryTalkBoxInfoList(String userId) {
        return userRepository.queryTalkBoxInfoList(userId);
    }

    @Override
    public void addTalkBoxInfo(String userId, String talkId, Integer talkType) {
        userRepository.addTalkBoxInfo(userId, talkId, talkType);
    }

    @Override
    public List<UserFriendInfo> queryUserFriendInfoList(String userId) {
        return userRepository.queryUserFriendInfoList(userId);
    }

    @Override
    public List<GroupsInfo> queryUserGroupInfoList(String userId) {
        return userRepository.queryUserGroupInfoList(userId);
    }

    @Override
    public List<LuckUserInfo> queryFuzzyUserInfoList(String userId, String searchKey) {
        return userRepository.queryFuzzyUserInfoList(userId, searchKey);
    }

    @Override
    public void addUserFriend(List<UserFriend> userFriendList) {
        userRepository.addUserFriend(userFriendList);
    }

    @Override
    public void asyncAppendChatRecord(final ChatRecordInfo chatRecordInfo) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userRepository.appendChatRecord(chatRecordInfo);
            }
        });
    }

    @Override
    public List<ChatRecordInfo> queryChatRecordInfoList(String talkId, String userId, Integer talkType) {
        return userRepository.queryChatRecordInfoList(talkId, userId, talkType);
    }

    @Override
    public void deleteUserTalk(String userId, String talkId) {
        userRepository.deleteUserTalk(userId, talkId);
    }

    @Override
    public List<String> queryUserGroupsIdList(String userId) {
        return userRepository.queryUserGroupsIdList(userId);
    }

    @Override
    public List<String> queryTalkBoxGroupsIdList(String userId) {
        return userRepository.queryTalkBoxGroupsIdList(userId);
    }

}
