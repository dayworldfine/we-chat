package cn.chat.ui.view.register;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import javafx.application.Platform;

import java.awt.*;

/**
 * @ClassName：RegisterController
 * @Description: 注册控制器
 * @Author：13738700108
 * @Data 2021/9/20 14:36
 * @Version: v1.0
 **/
public class RegisterController extends RegisterInit implements IRegisterMethod {

    private RegisterView registerView;
    private RegisterEventDefine registerEventDefine;

    public RegisterController(IRegisterEvent iRegisterEvent) {
        super(iRegisterEvent);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void countDown(String time) {
        sendCode.setText(time);
    }

    @Override
    public void registerSuccess() {
        registerError.setText("注册/找回密码成功");
        registerError.setStyle("-fx-text-fill: #129611;");
        registerError.setVisible(true);
        userPassword.setText("");
        userPasswordAgain.setText("");
    }

    @Override
    public void registerError(String msg) {
        registerError.setText(msg);
        registerError.setVisible(true);
        userPassword.setText("");
        userPasswordAgain.setText("");
    }

    @Override
    public void initView() {
        registerView = new RegisterView(this,iRegisterEvent);
    }

    @Override
    public void initEventDefine() {
        registerEventDefine = new RegisterEventDefine(this,iRegisterEvent,this);
    }
}
