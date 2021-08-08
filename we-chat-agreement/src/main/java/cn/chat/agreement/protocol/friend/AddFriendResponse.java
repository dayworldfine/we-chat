package cn.chat.agreement.protocol.friend;


import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;


/**
 * @ClassName：AddFriendResponse
 * @Description: 添加好友应答
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class AddFriendResponse extends Packet {

    private String friendId;
    private String friendNickName;
    private String friendHead;

    public AddFriendResponse() {
    }

    public AddFriendResponse(String friendId, String friendNickName, String friendHead) {
        this.friendId = friendId;
        this.friendNickName = friendNickName;
        this.friendHead = friendHead;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getFriendNickName() {
        return friendNickName;
    }

    public void setFriendNickName(String friendNickName) {
        this.friendNickName = friendNickName;
    }

    public String getFriendHead() {
        return friendHead;
    }

    public void setFriendHead(String friendHead) {
        this.friendHead = friendHead;
    }

    @Override
    public Byte getCommand() {
        return Command.AddFriendResponse;
    }
}
