package cn.chat.server.infrastructure.repository;

import cn.chat.server.domain.inet.model.ChannelUserInfo;
import cn.chat.server.domain.inet.model.ChannelUserReq;
import cn.chat.server.domain.inet.repository.IInetRepository;
import cn.chat.server.infrastructure.dao.IUserDao;
import cn.chat.server.infrastructure.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Repository("inetRepository")
public class InetRepository implements IInetRepository {

    @Autowired
    private IUserDao userDao;

    @Override
    public Long queryChannelUserCount(ChannelUserReq req) {
        return userDao.queryChannelUserCount(req);
    }

    @Override
    public List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req) {
        List<ChannelUserInfo> channelUserInfoList = new ArrayList<>();
        List<User> userList = userDao.queryChannelUserList(req);
        for (User user:userList){
            ChannelUserInfo channelUserInfo = new ChannelUserInfo();
            channelUserInfo.setUserId(user.getUserId());
            channelUserInfo.setUserNickName(user.getUserNickName());
            channelUserInfo.setUserHead(user.getUserHead());
            channelUserInfoList.add(channelUserInfo);
        }
        return channelUserInfoList;
    }
}
