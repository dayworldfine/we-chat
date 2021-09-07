package cn.chat.server.mapper;

import cn.chat.server.pojo.entity.Groups;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Mapper
public interface GroupsMapper {

    Groups queryGroupsById(@Param("groupsId")String groupsId);

}
