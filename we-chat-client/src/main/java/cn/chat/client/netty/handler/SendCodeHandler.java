package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.friend.SearchFriendResponse;
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
public class SendCodeHandler  extends SimpleChannelInboundHandler<SendCodeResponse> {

    private ActionBuilder actionBuilder;

    public SendCodeHandler(ActionBuilder actionBuilder) {
        this.actionBuilder = actionBuilder;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SendCodeResponse sendCodeResponse) {
        System.err.println("收到的短信:"+sendCodeResponse.getCode());
        IRegisterMethod registerMethod = actionBuilder.getRegisterMethod();
        new Thread(()->{
            AtomicInteger atomicInteger = new AtomicInteger(60);
            while (atomicInteger.get()>0){
                Platform.runLater(()->{
                    registerMethod.countDown(Convert.toStr(atomicInteger.get()));
                });
                atomicInteger.set(atomicInteger.get()-1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Platform.runLater(()->{
                registerMethod.countDown("发送验证码");
            });
        }).start();



    }
}
