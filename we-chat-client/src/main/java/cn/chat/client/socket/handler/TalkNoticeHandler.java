package cn.chat.client.socket.handler;

import cn.chat.agreement.protocol.talk.TalkNoticeResponse;
import cn.chat.client.application.UIService;
import cn.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @ClassName：TalkNoticeHandler
 * @Description: 对话通知应答
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class TalkNoticeHandler extends SimpleChannelInboundHandler<TalkNoticeResponse> {

    private UIService uiService;

    public TalkNoticeHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TalkNoticeResponse msg) throws Exception {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addTalkBox(-1, 0, msg.getTalkId(), msg.getTalkName(), msg.getTalkHead(), msg.getTalkSketch(), msg.getTalkDate(), false);
        });
    }

}
