package cn.chat.server.repository;

import cn.chat.server.pojo.model.inet.ChannelUserInfo;
import cn.chat.server.pojo.model.inet.ChannelUserReq;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public interface InetRepository {

    Long queryChannelUserCount(ChannelUserReq req);

    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
