package cn.chat.agreement.codec;

import cn.chat.agreement.protocol.Packet;
import cn.chat.agreement.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


/**
 * @ClassName：ObjEncoder
 * @Description: 编码器
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class ObjEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet in, ByteBuf out) {
        byte[] data = SerializationUtil.serialize(in);
        out.writeInt(data.length + 1);
        out.writeByte(in.getCommand()); //添加指令
        out.writeBytes(data);
    }

}
