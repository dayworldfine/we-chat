package cn.chat.server.netty.handler;

import cn.chat.agreement.protocol.register.SendCodeRequest;
import cn.chat.agreement.protocol.register.SendCodeResponse;
import cn.chat.server.helper.sms.SmsCondModel;
import cn.chat.server.helper.sms.SmsUtil;
import cn.chat.server.netty.MyBizHandler;
import cn.chat.server.service.UserService;
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
public class SendCodeHandler extends MyBizHandler<SendCodeRequest> {

    public SendCodeHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, SendCodeRequest msg) {
        logger.info("发送短信：{}", JSON.toJSONString(msg));
        doSendCode(msg.getPhone());
        SendCodeResponse response = new SendCodeResponse("");
        channel.writeAndFlush(response);
    }

    private void doSendCode(String account) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou","LTAIugLGMMRE80v9", "bLmjLAOpVXUKoPLCOQXbbY27Vh3VPX");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", SmsUtil.regionId);
        request.putQueryParameter("PhoneNumbers", account);
        request.putQueryParameter("SignName", SmsUtil.SignName);
        request.putQueryParameter("TemplateCode", SmsUtil.TemplateCode);
        String code = SmsUtil.generalRandomVeriCode();
        logger.info("code:{}",code);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        SmsUtil.map.put(account,new SmsCondModel(code,System.currentTimeMillis()));
        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info("发送短信结果:{}",response.getData());
        } catch (Exception e) {
            logger.error("发送短信异常,原因：{}",e.getMessage());
            e.printStackTrace();
        }
    }

}
