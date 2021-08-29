package cn.chat.client.netty;

import cn.chat.agreement.codec.ObjDecoder;
import cn.chat.agreement.codec.ObjEncoder;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.client.netty.handler.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ActionBuilder actionBuilder;

    public MyChannelInitializer(ActionBuilder actionBuilder) {
        this.actionBuilder = actionBuilder;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new AddFriendHandler(actionBuilder));
        channel.pipeline().addLast(new LoginHandler(actionBuilder));
        channel.pipeline().addLast(new MsgGroupHandler(actionBuilder));
        channel.pipeline().addLast(new MsgHandler(actionBuilder));
        channel.pipeline().addLast(new SearchFriendHandler(actionBuilder));
        channel.pipeline().addLast(new TalkNoticeHandler(actionBuilder));
        //对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }

}
