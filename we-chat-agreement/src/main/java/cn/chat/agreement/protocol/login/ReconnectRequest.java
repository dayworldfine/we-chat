package cn.chat.agreement.protocol.login;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class ReconnectRequest extends Packet {

    private String userId;

    public ReconnectRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public Byte getCommand() {
        return Command.ReconnectRequest;
    }
}
