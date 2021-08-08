package cn.chat.server.socket.handler;

import cn.chat.agreement.protocol.talk.DelTalkRequest;
import cn.chat.server.application.UserService;
import cn.chat.server.socket.MyBizHandler;
import io.netty.channel.Channel;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class DelTalkHandler extends MyBizHandler<DelTalkRequest> {

    public DelTalkHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, DelTalkRequest msg) {
        userService.deleteUserTalk(msg.getUserId(), msg.getTalkId());
    }
}
