package cn.chat.server.socket.handler;

import cn.chat.agreement.protocol.friend.SearchFriendRequest;
import cn.chat.agreement.protocol.friend.SearchFriendResponse;
import cn.chat.agreement.protocol.friend.dto.UserDto;
import cn.chat.server.application.UserService;
import cn.chat.server.domain.user.model.LuckUserInfo;
import cn.chat.server.socket.MyBizHandler;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class SearchFriendHandler extends MyBizHandler<SearchFriendRequest> {

    public SearchFriendHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, SearchFriendRequest msg) {
        logger.info("搜索好友请求处理：{}", JSON.toJSONString(msg));
        List<UserDto> userDtoList = new ArrayList<>();
        List<LuckUserInfo> userInfoList = userService.queryFuzzyUserInfoList(msg.getUserId(), msg.getSearchKey());
        for (LuckUserInfo userInfo : userInfoList) {
            UserDto userDto = new UserDto();
            userDto.setUserId(userInfo.getUserId());
            userDto.setUserNickName(userInfo.getUserNickName());
            userDto.setUserHead(userInfo.getUserHead());
            userDto.setStatus(userInfo.getStatus());
            userDtoList.add(userDto);
        }
        SearchFriendResponse response = new SearchFriendResponse();
        response.setList(userDtoList);
        channel.writeAndFlush(response);
    }

}
