package cn.chat.server.mapper;

import cn.chat.server.pojo.entity.ChatRecord;
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
public interface ChatRecordMapper {

    void appendChatRecord(@Param("req")ChatRecord req);

    List<ChatRecord> queryUserChatRecordList(@Param("talkId")String talkId,@Param("userId") String userId);

    List<ChatRecord> queryGroupsChatRecordList(@Param("talkId") String talkId,@Param("userId")  String userId);

}
