package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.talk.TalkNoticeRequest;
import cn.chat.agreement.protocol.talk.TalkNoticeResponse;
import cn.chat.server.service.UserService;
import cn.chat.server.pojo.info.UserInfo;
import cn.chat.server.common.SocketChannelUtil;
import cn.chat.server.netty.MyBizHandler;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;

import java.util.Date;

/**

 * 对话通知应答处理
 */
public class TalkNoticeHandler extends MyBizHandler<TalkNoticeRequest> {

    public TalkNoticeHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, TalkNoticeRequest msg) {
        logger.info("对话通知应答处理：{}", JSON.toJSONString(msg));

        switch (msg.getTalkType()) {
            case 0:
                // 1. 对话框数据落库
                userService.addTalkBoxInfo(msg.getUserId(), msg.getFriendUserId(), 0);
                userService.addTalkBoxInfo(msg.getFriendUserId(), msg.getUserId(), 0);
                // 2. 查询对话框信息[将自己发给好友的对话框中]
                UserInfo userInfo = userService.queryUserInfo(msg.getUserId());
                // 3. 发送对话框消息给好友
                TalkNoticeResponse response = new TalkNoticeResponse();
                response.setTalkId(userInfo.getUserId());
                response.setTalkName(userInfo.getUserNickName());
                response.setTalkHead(userInfo.getUserHead());
                response.setTalkSketch(null);
                response.setTalkDate(new Date());
                // 获取好友通信管道
                Channel friendChannel = SocketChannelUtil.getChannel(msg.getFriendUserId());
                if (null == friendChannel) {
                    logger.info("用户id：{}未登录！", msg.getFriendUserId());
                    return;
                }
                friendChannel.writeAndFlush(response);
                break;
            case 1:
                userService.addTalkBoxInfo(msg.getUserId(), msg.getFriendUserId(), 1);
                break;
            default:
                break;
        }

    }

}
