package cn.chat.ui.view.login;

/**
 * @ClassName：ILoginMethod
 * @Description: 窗口方法，给予外部调用
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public interface ILoginMethod {

    /**
     * 打开登陆窗口
     */
    void doShow();

    /**
     * 登陆失败
     */
    void doLoginError();

    /**
     * 登陆成功；跳转聊天窗口[关闭登陆窗口，打开新窗口]
     */
    void doLoginSuccess();

    /**
     * 打开注册串口
     */
    void doShowRegister();

}
