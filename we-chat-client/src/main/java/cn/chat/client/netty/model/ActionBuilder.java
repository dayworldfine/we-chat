package cn.chat.client.netty.model;

import cn.chat.ui.view.chat.IChatMethod;
import cn.chat.ui.view.login.ILoginMethod;
import cn.chat.ui.view.register.IRegisterMethod;

/**
 * @ClassName：UIService
 * @Description: 网络服务
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class ActionBuilder {

    private ILoginMethod login;
    private IChatMethod chat;
    private IRegisterMethod registerMethod;

    public ILoginMethod getLogin() {
        return login;
    }

    public void setLogin(ILoginMethod login) {
        this.login = login;
    }

    public IChatMethod getChat() {
        return chat;
    }

    public void setChat(IChatMethod chat) {
        this.chat = chat;
    }

    public IRegisterMethod getRegisterMethod() {
        return registerMethod;
    }

    public void setRegisterMethod(IRegisterMethod registerMethod) {
        this.registerMethod = registerMethod;
    }
}
