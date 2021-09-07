package cn.chat.server.mapper;

import cn.chat.server.pojo.entity.UserFriend;
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
public interface UserFriendMapper {

    List<String> queryUserFriendIdList(@Param("userId")String userId);

    UserFriend queryUserFriendById(@Param("userFriend")UserFriend userFriend);

    void addUserFriendList(@Param("userFriendList")List<UserFriend> userFriendList);

}
