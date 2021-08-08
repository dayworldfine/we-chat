package cn.chat.server.application;

import cn.chat.server.domain.inet.model.ChannelUserInfo;
import cn.chat.server.domain.inet.model.ChannelUserReq;
import cn.chat.server.domain.inet.model.InetServerInfo;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public interface InetService {

    InetServerInfo queryNettyServerInfo();

    Long queryChannelUserCount(ChannelUserReq req);

    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
