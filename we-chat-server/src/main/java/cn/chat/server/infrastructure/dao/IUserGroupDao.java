package cn.chat.server.infrastructure.dao;

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
public interface IUserGroupDao {

    List<String> queryUserGroupsIdList(String userId);

}
