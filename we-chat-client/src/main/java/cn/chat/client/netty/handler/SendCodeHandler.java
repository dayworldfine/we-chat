package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.friend.SearchFriendResponse;
import cn.chat.agreement.protocol.register.SendCodeResponse;
import cn.chat.client.netty.model.ActionBuilder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
        System.err.println("sad:"+sendCodeResponse.getCode());

    }
}
