package cn.chat.server.mapper;

import cn.chat.server.pojo.entity.TalkBox;
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
public interface TalkBoxMapper {

    List<TalkBox> queryTalkBoxList(@Param("userId")String userId);

    void addTalkBox(@Param("talkBox") TalkBox talkBox);

    void deleteUserTalk(@Param("userId")String userId, @Param("talkId")String talkId);

    TalkBox queryTalkBox(@Param("userId") String userId,@Param("talkId")  String talkId);

    List<String> queryTalkBoxGroupsIdList(@Param("userId")String userId);

}
