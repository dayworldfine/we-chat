package cn.chat.server.infrastructure.dao;

import cn.chat.server.infrastructure.po.Groups;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Mapper
public interface IGroupsDao {

    Groups queryGroupsById(String groupsId);

}
