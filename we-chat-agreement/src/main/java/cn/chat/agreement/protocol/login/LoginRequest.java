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
public class LoginRequest extends Packet {

    private String userId;        // 用户ID
    private String userPassword;  // 用户密码

    public LoginRequest(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public Byte getCommand() {
        return Command.LoginRequest;
    }

}
