package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.msg.MsgGroupRequest;
import cn.chat.agreement.protocol.msg.MsgGroupResponse;
import cn.chat.server.common.enums.TalkTypeEnum;
import cn.chat.server.service.UserService;
import cn.chat.server.pojo.info.ChatRecordInfo;
import cn.chat.server.pojo.info.UserInfo;
import cn.chat.server.common.SocketChannelUtil;
import cn.chat.server.netty.MyBizHandler;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

/**

 * 群组消息发送
 */
public class MsgGroupHandler extends MyBizHandler<MsgGroupRequest> {

    public MsgGroupHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, MsgGroupRequest msg) {
        // 获取群组通信管道
        ChannelGroup channelGroup = SocketChannelUtil.getChannelGroup(msg.getTalkId());
        if (null == channelGroup) {
            SocketChannelUtil.addChannelGroup(msg.getTalkId(), channel);
            channelGroup = SocketChannelUtil.getChannelGroup(msg.getTalkId());
        }
        // 异步写库
        userService.asyncAppendChatRecord(new ChatRecordInfo(msg.getUserId(), msg.getTalkId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate(), TalkTypeEnum.Group.getCode()));
        // 群发消息
        UserInfo userInfo = userService.queryUserInfo(msg.getUserId());
        MsgGroupResponse msgGroupResponse = new MsgGroupResponse();
        msgGroupResponse.setTalkId(msg.getTalkId());
        msgGroupResponse.setUserId(msg.getUserId());
        msgGroupResponse.setUserNickName(userInfo.getUserNickName());
        msgGroupResponse.setUserHead(userInfo.getUserHead());
        msgGroupResponse.setMsg(msg.getMsgText());
        msgGroupResponse.setMsgType(msg.getMsgType());
        msgGroupResponse.setMsgDate(msg.getMsgDate());
        channelGroup.writeAndFlush(msgGroupResponse);
    }

}
