package cn.chat.ui.view.login;


import cn.chat.ui.view.chat.IChatMethod;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class LoginController extends LoginInit implements ILoginMethod {

    private IChatMethod chat;
    private LoginView loginView;
    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent loginEvent, IChatMethod chat) {
        super(loginEvent);
        this.chat = chat;
    }

    @Override
    public void initView() {
        loginView = new LoginView(this, loginEvent);
    }

    @Override
    public void initEventDefine() {
        loginEventDefine = new LoginEventDefine(this, loginEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void doLoginError() {
        // TODO 登陆失败提示
    }

    @Override
    public void doLoginSuccess() {
        // 关闭原窗口
        close();
        // 打开聊天窗口
        chat.doShow();
    }

}
