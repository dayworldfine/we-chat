package cn.chat.ui.view.register;

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
        quit();              // 退出
    }
    // 退出
    private void quit() {
        registerInit.$("registerClose", Button.class).setOnAction(event -> {
            iRegisterEvent.doQuit();
            registerInit.close();
        });
    }
}
