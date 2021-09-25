package cn.chat.server.mapper;

import cn.chat.server.pojo.model.inet.ChannelUserReq;
import cn.chat.server.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Mapper
public interface UserMapper {

    String queryUserPassword(@Param("userId")String userId);

    User queryUserById(@Param("userId")String userId);

    List<User> queryFuzzyUserList(@Param("userId")String userId,@Param("searchKey") String searchKey);

    Long queryChannelUserCount(@Param("channelUserReq")ChannelUserReq channelUserReq);

    List<User> queryChannelUserList(@Param("channelUserReq")ChannelUserReq channelUserReq);

    void insertUser(@Param("userId")String userId,@Param("userHead") String userHead,
                    @Param("nickName")String nickName,@Param("password") String password);

    void updateUser(@Param("userId")String userId,@Param("userHead") String userHead,
                    @Param("nickName")String nickName,@Param("password") String password);
}
