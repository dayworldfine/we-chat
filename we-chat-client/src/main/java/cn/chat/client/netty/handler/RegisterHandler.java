package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.register.RegisterResponse;
import cn.chat.agreement.protocol.register.SendCodeResponse;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.ui.view.register.IRegisterMethod;
import cn.hutool.core.convert.Convert;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName：SendCodeHandler
 * @Description:
 * @Author：13738700108
 * @Data 2021/9/21 15:23
 * @Version: v1.0
 **/
public class RegisterHandler extends SimpleChannelInboundHandler<RegisterResponse> {

    private ActionBuilder actionBuilder;

    public RegisterHandler(ActionBuilder actionBuilder) {
        this.actionBuilder = actionBuilder;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterResponse registerResponse) throws Exception {
        IRegisterMethod registerMethod = actionBuilder.getRegisterMethod();
        if (registerResponse.getSuccess()){
            Platform.runLater(()->{
                registerMethod.registerSuccess();
            });
        }else {
            Platform.runLater(()->{
                registerMethod.registerError(registerResponse.getErrorMsg());
            });
        }
    }
}
