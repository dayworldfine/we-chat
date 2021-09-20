package cn.chat.ui.view.login;

import cn.chat.ui.view.face.FaceController;
import cn.chat.ui.view.register.IRegisterMethod;
import cn.chat.ui.view.register.RegisterController;
import javafx.scene.control.Button;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class LoginEventDefine {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;
    private ILoginMethod loginMethod;

    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;
        loginInit.move();
        min();
        quit();
        loginError();
        doEventLogin();
        doRegister();
    }

    /**
     * 事件：注册
     */
    private void doRegister() {
        loginInit.registerButton.setOnAction(event -> {
            loginMethod.doShowRegister();
        });
    }


    // 事件；最小化
    private void min() {
        loginInit.login_min.setOnAction(event -> {
            loginInit.setIconified(true);
        });
    }

    // 事件；退出
    private void quit() {
        loginInit.login_close.setOnAction(event -> {
            loginInit.close();
            System.exit(0);
        });
    }

    // 事件；登陆
    private void doEventLogin() {
        loginInit.login_button.setOnAction(event -> {
            loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
        });
    }

    //事件：登录错误
    private void loginError(){
        loginInit.loginError.setVisible(false);
    }
}
