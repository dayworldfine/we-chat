package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.msg.MsgResponse;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class MsgHandler extends SimpleChannelInboundHandler<MsgResponse> {

    private ActionBuilder actionBuilder;

    public MsgHandler(ActionBuilder actionBuilder) {
        this.actionBuilder = actionBuilder;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgResponse msg) throws Exception {
        IChatMethod chat = actionBuilder.getChat();
        Platform.runLater(() -> {
            chat.addTalkMsgUserLeft(msg.getFriendId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
        });
    }

}
