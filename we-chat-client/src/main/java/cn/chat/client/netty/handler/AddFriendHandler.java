package cn.chat.client.netty.handler;

import cn.chat.agreement.protocol.friend.AddFriendResponse;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.client.netty.MyBizHandler;
import cn.chat.ui.view.chat.IChatMethod;
import io.netty.channel.Channel;
import javafx.application.Platform;

/**
 * @ClassName：AddFriendHandler
 * @Description: 添加好友
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class AddFriendHandler extends MyBizHandler<AddFriendResponse> {

    public AddFriendHandler(ActionBuilder actionBuilder) {
        super(actionBuilder);
    }

    @Override
    public void channelRead(Channel channel, AddFriendResponse msg) {
        IChatMethod chat = actionBuilder.getChat();
        Platform.runLater(() -> {
            chat.addFriendUser(true, msg.getFriendId(), msg.getFriendNickName(), msg.getFriendHead());
        });
    }

}
