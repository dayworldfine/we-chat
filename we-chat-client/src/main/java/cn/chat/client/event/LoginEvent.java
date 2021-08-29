package cn.chat.client.event;

import cn.chat.agreement.protocol.login.LoginRequest;
import cn.chat.client.util.BeanUtil;
import cn.chat.client.util.CacheUtil;
import cn.chat.ui.view.login.ILoginEvent;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName：LoginEvent
 * @Description: 登陆窗口
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class LoginEvent implements ILoginEvent {

    private Logger logger = LoggerFactory.getLogger(LoginEvent.class);

    @Override
    public void doLoginCheck(String userId, String userPassword) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new LoginRequest(userId, userPassword));
        CacheUtil.userId = userId;
    }

}
