package cn.chat.server.domain.inet.repository;

import cn.chat.server.domain.inet.model.ChannelUserInfo;
import cn.chat.server.domain.inet.model.ChannelUserReq;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public interface IInetRepository {

    Long queryChannelUserCount(ChannelUserReq req);

    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
