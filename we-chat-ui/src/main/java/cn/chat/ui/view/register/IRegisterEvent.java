package cn.chat.ui.view.register;

/**
 * @ClassName：RegisterEvent
 * @Description: 窗口方法，给予外部调用
 * @Author：13738700108
 * @Data 2021/9/20 14:38
 * @Version: v1.0
 **/
public interface IRegisterEvent {

    /**
     * 聊天窗口退出操作
     */
    void doQuit();

    /**
     * 发送短信
     */
    void doSendCode(String phone);



    /**
     * 注册/找回密码
     */
    void doRegisterAccount(String phone, String code, String nickName, String userPassword);

}
