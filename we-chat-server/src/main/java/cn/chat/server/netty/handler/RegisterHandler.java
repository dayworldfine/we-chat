package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.register.RegisterRequest;
import cn.chat.agreement.protocol.register.RegisterResponse;
import cn.chat.agreement.protocol.register.SendCodeRequest;
import cn.chat.agreement.protocol.register.SendCodeResponse;
import cn.chat.server.helper.sms.SmsCondModel;
import cn.chat.server.helper.sms.SmsUtil;
import cn.chat.server.netty.MyBizHandler;
import cn.chat.server.service.UserService;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import io.netty.channel.Channel;


/**
 * @ClassName：SendCodeHandler
 * @Description: 发送消息
 * @Author：13738700108
 * @Data 2021/9/21 15:13
 * @Version: v1.0
 **/
public class RegisterHandler extends MyBizHandler<RegisterRequest> {

    public RegisterHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, RegisterRequest msg) {
        logger.info("收到的内容：{}", JSON.toJSONString(msg));
        /** 验证手机验证码是否有效*/
        SmsCondModel smsCondModel = SmsUtil.map.get(msg.getPhone());
        if (ObjectUtil.isEmpty(smsCondModel)){
            channel.writeAndFlush(new RegisterResponse(false,"验证码无效"));
            return;
        }
        if (!smsCondModel.getCode().equals(msg.getCode())){
            channel.writeAndFlush(new RegisterResponse(false,"验证码无效"));
            return;
        }
        userService.registerOrUpdate(msg);
        channel.writeAndFlush(new RegisterResponse(true,""));
    }


}
