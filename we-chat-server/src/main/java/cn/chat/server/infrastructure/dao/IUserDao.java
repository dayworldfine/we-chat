package cn.chat.server.infrastructure.dao;

import cn.chat.server.domain.inet.model.ChannelUserReq;
import cn.chat.server.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Mapper
public interface IUserDao {

    String queryUserPassword(String userId);

    User queryUserById(String userId);

    List<User> queryFuzzyUserList(String userId, String searchKey);

    Long queryChannelUserCount(ChannelUserReq req);

    List<User> queryChannelUserList(ChannelUserReq req);

}
