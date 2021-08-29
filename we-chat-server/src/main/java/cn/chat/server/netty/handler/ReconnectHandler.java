package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.login.ReconnectRequest;
import cn.chat.server.service.UserService;
import cn.chat.server.common.SocketChannelUtil;
import cn.chat.server.netty.MyBizHandler;
import io.netty.channel.Channel;

import java.util.List;

/**

 * 重连处理
 */
public class ReconnectHandler extends MyBizHandler<ReconnectRequest> {

    public ReconnectHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, ReconnectRequest msg) {
        logger.info("客户端断线重连处理。userId：{}", msg.getUserId());
        // 添加用户Channel
        SocketChannelUtil.removeUserChannelByUserId(msg.getUserId());
        SocketChannelUtil.addChannel(msg.getUserId(), channel);
        // 添加群组Channel
        List<String> groupsIdList = userService.queryTalkBoxGroupsIdList(msg.getUserId());
        for (String groupsId : groupsIdList) {
            SocketChannelUtil.addChannelGroup(groupsId, channel);
        }
    }

}
