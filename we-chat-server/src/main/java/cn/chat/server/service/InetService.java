package cn.chat.server.service;

import cn.chat.server.pojo.model.inet.ChannelUserInfo;
import cn.chat.server.pojo.model.inet.ChannelUserReq;
import cn.chat.server.pojo.model.inet.InetServerInfo;

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
