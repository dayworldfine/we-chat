package cn.chat.agreement.protocol.friend;

import cn.chat.agreement.protocol.Command;
import cn.chat.agreement.protocol.Packet;
import cn.chat.agreement.protocol.friend.dto.UserDto;

import java.util.List;

/**
 * @ClassName：SearchFriendResponse
 * @Description: 搜索好友应答
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class SearchFriendResponse extends Packet {

    private List<UserDto> list;

    public List<UserDto> getList() {
        return list;
    }

    public void setList(List<UserDto> list) {
        this.list = list;
    }

    @Override
    public Byte getCommand() {
        return Command.SearchFriendResponse;
    }
}
