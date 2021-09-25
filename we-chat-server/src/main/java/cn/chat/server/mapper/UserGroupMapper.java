package cn.chat.server.mapper;

import cn.hutool.core.date.DateTime;
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
public interface UserGroupMapper {

    List<String> queryUserGroupsIdList(@Param("userId")String userId);

    void insertUserGroup(@Param("userId") String userId, @Param("groupId") int groupId,@Param("date") DateTime date);
}
