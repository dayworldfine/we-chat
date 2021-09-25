package cn.chat.ui.view.register;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.extra.validation.ValidationUtil;
import javafx.scene.control.Button;

/**
 * @ClassName：RegisterEventDefine
 * @Description: 事件定义
 * @Author：13738700108
 * @Data 2021/9/20 16:26
 * @Version: v1.0
 **/
public class RegisterEventDefine {

    private RegisterInit registerInit;
    private IRegisterEvent iRegisterEvent;
    private IRegisterMethod iRegisterMethod;

    public RegisterEventDefine(RegisterInit registerInit, IRegisterEvent iRegisterEvent, IRegisterMethod iRegisterMethod) {
        this.registerInit = registerInit;
        this.iRegisterEvent = iRegisterEvent;
        this.iRegisterMethod = iRegisterMethod;
        registerInit.move();
        quit();
        sendCode();
        registerAccount();

    }

    /**
     * 事件:注册账号/找回密码
     */
    private void registerAccount() {
        registerInit.registerAccount.setOnAction(event -> {
            /** 清除*/
            registerInit.registerError.setText("");
            registerInit.registerError.setVisible(false);
            /** 验证密码是否一致*/
            String phone = registerInit.phone.getText();
            String code = registerInit.code.getText();
            String nickName = registerInit.nickName.getText();
            String userPassword = registerInit.userPassword.getText();
            String userPasswordAgain = registerInit.userPasswordAgain.getText();
            if (ObjectUtil.isEmpty(phone)){
                registerInit.registerError.setText("手机号码须填写");
                registerInit.registerError.setVisible(true);
                return;
            }
            if (ObjectUtil.isEmpty(code)){
                registerInit.registerError.setText("验证码须填写");
                registerInit.registerError.setVisible(true);
                return;
            }
            if (ObjectUtil.isEmpty(nickName)){
                registerInit.registerError.setText("昵称须填写");
                registerInit.registerError.setVisible(true);
                return;
            }
            if (ObjectUtil.isEmpty(userPassword)){
                registerInit.registerError.setText("密码须填写");
                registerInit.registerError.setVisible(true);
                return;
            }
            if (!userPassword.equals(userPasswordAgain)){
                registerInit.registerError.setText("两次输入的密码不一致");
                registerInit.registerError.setVisible(true);
                return;
            }
            iRegisterEvent.doRegisterAccount(phone,code,nickName,userPassword);

        });
    }

    /**
     * 事件：发送验证码
     * 1.检查是否幂等
     * 2.检验手机号是否正常
     * 3.调用发送验证码
     */
    private void sendCode() {
        registerInit.sendCode.setOnAction(event -> {
            /** 清除*/
            registerInit.registerError.setText("");
            registerInit.registerError.setVisible(false);
            /** 如果是数字*/
            if ( NumberUtil.isNumber(registerInit.sendCode.getText())){
                return;
            }
            String telRegex = "^(1)\\d{10}$";
            if (!ReUtil.isMatch(telRegex, registerInit.phone.getText())){
                registerInit.registerError.setText("手机号格式不正确");
                registerInit.registerError.setVisible(true);
                return;
            }
            iRegisterEvent.doSendCode(registerInit.phone.getText());
        });
    }

    // 退出
    private void quit() {
        registerInit.$("registerClose", Button.class).setOnAction(event -> {
            iRegisterEvent.doQuit();
            registerInit.close();
        });
    }
}
