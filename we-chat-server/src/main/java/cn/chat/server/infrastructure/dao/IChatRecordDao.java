package cn.chat.server.infrastructure.dao;

import cn.chat.server.infrastructure.po.ChatRecord;
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
public interface IChatRecordDao {

    void appendChatRecord(ChatRecord req);

    List<ChatRecord> queryUserChatRecordList(@Param("talkId")String talkId,@Param("userId") String userId);

    List<ChatRecord> queryGroupsChatRecordList(@Param("talkId") String talkId,@Param("userId")  String userId);

}
