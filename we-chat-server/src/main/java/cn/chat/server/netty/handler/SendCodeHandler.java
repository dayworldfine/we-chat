package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.register.SendCodeRequest;
import cn.chat.agreement.protocol.register.SendCodeResponse;
import cn.chat.server.netty.MyBizHandler;
import cn.chat.server.service.UserService;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;


/**
 * @ClassName：SendCodeHandler
 * @Description: 发送消息
 * @Author：13738700108
 * @Data 2021/9/21 15:13
 * @Version: v1.0
 **/
public class SendCodeHandler extends MyBizHandler<SendCodeRequest> {

    public SendCodeHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, SendCodeRequest msg) {
        logger.info("发送短信：{}", JSON.toJSONString(msg));

        SendCodeResponse response = new SendCodeResponse("wbh123");
        channel.writeAndFlush(response);
    }
}
