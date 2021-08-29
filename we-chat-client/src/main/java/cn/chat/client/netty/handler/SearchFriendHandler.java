package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.friend.SearchFriendResponse;
import cn.chat.agreement.protocol.friend.dto.UserDto;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class SearchFriendHandler extends SimpleChannelInboundHandler<SearchFriendResponse> {

    private ActionBuilder actionBuilder;

    public SearchFriendHandler(ActionBuilder actionBuilder) {
        this.actionBuilder = actionBuilder;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SearchFriendResponse msg) throws Exception {
        List<UserDto> list = msg.getList();
        if (null == list || list.isEmpty()) return;
        IChatMethod chat = actionBuilder.getChat();
        Platform.runLater(() -> {
            for (UserDto user : list) {
                chat.addLuckFriend(user.getUserId(), user.getUserNickName(), user.getUserHead(), user.getStatus());
            }
        });
    }

}
