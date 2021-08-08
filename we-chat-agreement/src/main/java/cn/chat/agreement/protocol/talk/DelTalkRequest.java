package cn.chat.agreement.protocol.talk;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：DelTalkRequest
 * @Description: 删除对话框请求
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class DelTalkRequest extends Packet {

    private String userId;  // 用户ID
    private String talkId;  // 对话框ID

    public DelTalkRequest() {
    }

    public DelTalkRequest(String userId, String talkId) {
        this.userId = userId;
        this.talkId = talkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    @Override
    public Byte getCommand() {
        return Command.DelTalkRequest;
    }
}
