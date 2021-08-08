package cn.chat.ui.view.login;


/**
 * @ClassName：LoginView
 * @Description: 页面展示元素和事件定义
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class LoginView {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }

}
