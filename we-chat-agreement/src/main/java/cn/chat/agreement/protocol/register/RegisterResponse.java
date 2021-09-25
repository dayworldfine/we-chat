package cn.chat.agreement.protocol.register;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：RegisterResponse
 * @Description: 注册返回
 * @Author：13738700108
 * @Data 2021/9/25 11:05
 * @Version: v1.0
 **/
public class RegisterResponse extends Packet {

    private Boolean isSuccess;

    private String errorMsg;

    public RegisterResponse() {
    }

    public RegisterResponse(Boolean isSuccess, String errorMsg) {
        this.isSuccess = isSuccess;
        this.errorMsg = errorMsg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public Byte getCommand() {
        return Command.RegisterResponse;
    }

}
