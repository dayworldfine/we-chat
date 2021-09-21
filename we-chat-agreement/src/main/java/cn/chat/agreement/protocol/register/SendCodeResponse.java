package cn.chat.agreement.protocol.register;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：SendCodeResponse
 * @Description: 发送验证码返回
 * @Author：13738700108
 * @Data 2021/9/21 15:02
 * @Version: v1.0
 **/
public class SendCodeResponse extends Packet {

    private String code;

    public SendCodeResponse() {
    }

    public SendCodeResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Byte getCommand() {
        return Command.SendCodeResponse;
    }
}
