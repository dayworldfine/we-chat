package cn.chat.agreement.protocol.register;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：SendCodeRequest
 * @Description: 发送短信请求
 * @Author：13738700108
 * @Data 2021/9/21 15:00
 * @Version: v1.0
 **/
public class SendCodeRequest extends Packet {

    private String phone;

    public SendCodeRequest() {
    }

    public SendCodeRequest(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Byte getCommand() {
        return Command.SendCodeRequest;
    }
}
