package cn.chat.agreement.protocol;

import cn.chat.agreement.protocol.friend.AddFriendRequest;
import cn.chat.agreement.protocol.friend.AddFriendResponse;
import cn.chat.agreement.protocol.friend.SearchFriendRequest;
import cn.chat.agreement.protocol.friend.SearchFriendResponse;
import cn.chat.agreement.protocol.login.LoginRequest;
import cn.chat.agreement.protocol.login.LoginResponse;
import cn.chat.agreement.protocol.login.ReconnectRequest;
import cn.chat.agreement.protocol.msg.MsgGroupRequest;
import cn.chat.agreement.protocol.msg.MsgGroupResponse;
import cn.chat.agreement.protocol.msg.MsgRequest;
import cn.chat.agreement.protocol.msg.MsgResponse;
import cn.chat.agreement.protocol.talk.DelTalkRequest;
import cn.chat.agreement.protocol.talk.TalkNoticeRequest;
import cn.chat.agreement.protocol.talk.TalkNoticeResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName：Packet
 * @Description: 协议包
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public abstract class Packet {

    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

    static {
        packetType.put(Command.LoginRequest, LoginRequest.class);
        packetType.put(Command.LoginResponse, LoginResponse.class);
        packetType.put(Command.MsgRequest, MsgRequest.class);
        packetType.put(Command.MsgResponse, MsgResponse.class);
        packetType.put(Command.TalkNoticeRequest, TalkNoticeRequest.class);
        packetType.put(Command.TalkNoticeResponse, TalkNoticeResponse.class);
        packetType.put(Command.SearchFriendRequest, SearchFriendRequest.class);
        packetType.put(Command.SearchFriendResponse, SearchFriendResponse.class);
        packetType.put(Command.AddFriendRequest, AddFriendRequest.class);
        packetType.put(Command.AddFriendResponse, AddFriendResponse.class);
        packetType.put(Command.DelTalkRequest, DelTalkRequest.class);
        packetType.put(Command.MsgGroupRequest, MsgGroupRequest.class);
        packetType.put(Command.MsgGroupResponse, MsgGroupResponse.class);
        packetType.put(Command.ReconnectRequest, ReconnectRequest.class);
    }

    public static Class<? extends Packet> get(Byte command) {
        return packetType.get(command);
    }

    /**
     * 获取协议指令
     *
     * @return 返回指令值
     */
    public abstract Byte getCommand();

}
