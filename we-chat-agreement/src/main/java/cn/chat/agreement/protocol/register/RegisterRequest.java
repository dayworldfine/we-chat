package cn.chat.agreement.protocol.register;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：RegisterRequest
 * @Description: 注册/找回密码 请求
 * @Author：13738700108
 * @Data 2021/9/25 11:03
 * @Version: v1.0
 **/
public class RegisterRequest extends Packet {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String phone, String code, String nickName, String password) {
        this.phone = phone;
        this.code = code;
        this.nickName = nickName;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return Command.RegisterRequest;
    }
}
