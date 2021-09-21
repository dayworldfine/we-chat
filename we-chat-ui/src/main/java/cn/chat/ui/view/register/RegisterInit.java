package cn.chat.ui.view.register;

import cn.chat.ui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @ClassName：RegisterInit
 * @Description: 注册初始化
 * @Author：13738700108
 * @Data 2021/9/20 14:37
 * @Version: v1.0
 **/
public abstract class RegisterInit extends UIObject {

    private static final String RESOURCE_NAME = "/fxml/register/register.fxml";

    protected IRegisterEvent iRegisterEvent;

    public Button registerClose;          // 关闭
    public TextField phone;          // 用户手机号
    public TextField code;          // 验证码
    public Button sendCode;          // 发送验证码
    public PasswordField userPassword;// 用户密码窗口
    public PasswordField userPasswordAgain;// 用户再次输入密码窗口
    public Button registerAccount;        // 注册/找回密码

    public RegisterInit(IRegisterEvent iRegisterEvent) {
        this.iRegisterEvent = iRegisterEvent;
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 模态窗口
        initModality(Modality.NONE);
        // 初始化页面&事件
        obtain();
        initView();
        initEventDefine();
    }

    protected void obtain(){
        registerClose = $("registerClose", Button.class);
        phone = $("phone", TextField.class);
        code = $("code", TextField.class);
        sendCode = $("sendCode", Button.class);
        userPassword = $("userPassword", PasswordField.class);
        userPasswordAgain = $("userPasswordAgain", PasswordField.class);
        registerAccount = $("registerAccount", Button.class);
    }
}
