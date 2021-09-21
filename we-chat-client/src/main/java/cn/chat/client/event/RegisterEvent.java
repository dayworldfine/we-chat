package cn.chat.client.event;

import cn.chat.agreement.protocol.login.LoginRequest;
import cn.chat.agreement.protocol.register.SendCodeRequest;
import cn.chat.client.util.BeanUtil;
import cn.chat.client.util.CacheUtil;
import cn.chat.ui.view.register.IRegisterEvent;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName：RegisterEvent
 * @Description: 注册窗口
 * @Author：13738700108
 * @Data 2021/9/21 8:41
 * @Version: v1.0
 **/
public class RegisterEvent implements IRegisterEvent {

    private Logger logger = LoggerFactory.getLogger(RegisterEvent.class);

    @Override
    public void doQuit() {

    }

    @Override
    public void doSendCode(String phone) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new SendCodeRequest(phone));
    }

}
