package cn.chat.ui.view.register;


/**
 * @ClassName：RegisterView
 * @Description: 页面展示元素和事件定义
 * @Author：13738700108
 * @Data 2021/9/20 14:40
 * @Version: v1.0
 **/
public class RegisterView {

    private RegisterInit registerInit;
    private IRegisterEvent iRegisterEvent;

    public RegisterView(RegisterInit registerInit, IRegisterEvent iRegisterEvent) {
        this.registerInit = registerInit;
        this.iRegisterEvent = iRegisterEvent;
    }
}
