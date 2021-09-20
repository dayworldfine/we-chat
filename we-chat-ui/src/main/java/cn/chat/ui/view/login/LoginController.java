package cn.chat.ui.view.login;


import cn.chat.ui.view.chat.IChatMethod;
import cn.chat.ui.view.register.IRegisterMethod;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class LoginController extends LoginInit implements ILoginMethod {

    private IChatMethod chat;
    private IRegisterMethod iRegisterMethod;
    private LoginView loginView;
    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent loginEvent, IChatMethod chat,IRegisterMethod iRegisterMethod) {
        super(loginEvent);
        this.chat = chat;
        this.iRegisterMethod = iRegisterMethod;
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
        loginError.setVisible(true);
    }

    @Override
    public void doLoginSuccess() {
        // 关闭原窗口
        close();
        // 打开聊天窗口
        chat.doShow();
    }

    @Override
    public void doShowRegister() {
        iRegisterMethod.doShow();
    }

}
