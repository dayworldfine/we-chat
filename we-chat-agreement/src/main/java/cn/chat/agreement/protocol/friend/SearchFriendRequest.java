package cn.chat.agreement.protocol.friend;


import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;


/**
 * @ClassName：SearchFriendRequest
 * @Description: 搜索好友请求
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class SearchFriendRequest extends Packet {

    private String userId;     // 用户ID
    private String searchKey;  // 搜索字段

    public SearchFriendRequest() {
    }

    public SearchFriendRequest(String userId, String searchKey) {
        this.userId = userId;
        this.searchKey = searchKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public Byte getCommand() {
        return Command.SearchFriendRequest;
    }

}
