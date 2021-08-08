package cn.chat.client.socket.handler;

import cn.chat.agreement.protocol.friend.AddFriendResponse;
import cn.chat.client.application.UIService;
import cn.chat.client.socket.MyBizHandler;
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

    public AddFriendHandler(UIService uiService) {
        super(uiService);
    }

    @Override
    public void channelRead(Channel channel, AddFriendResponse msg) {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addFriendUser(true, msg.getFriendId(), msg.getFriendNickName(), msg.getFriendHead());
        });
    }

}
