package cn.chat.ui.view.register;


import cn.chat.ui.view.UIObject;
import cn.chat.ui.view.chat.ChatEventDefine;
import cn.chat.ui.view.chat.ChatView;

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
    public void initView() {
        registerView = new RegisterView(this,iRegisterEvent);
    }

    @Override
    public void initEventDefine() {
        registerEventDefine = new RegisterEventDefine(this,iRegisterEvent,this);
    }
}
