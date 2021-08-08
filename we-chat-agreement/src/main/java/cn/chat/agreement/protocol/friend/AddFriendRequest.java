package cn.chat.agreement.protocol.friend;


import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;

/**
 * @ClassName：AddFriendRequest
 * @Description: 添加好友请求
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class AddFriendRequest extends Packet {

    private String userId;    // 用户ID[自己的ID]
    private String friendId;  // 好友ID

    public AddFriendRequest(){}

    public AddFriendRequest(String userId, String friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public Byte getCommand() {
        return Command.AddFriendRequest;
    }

}
