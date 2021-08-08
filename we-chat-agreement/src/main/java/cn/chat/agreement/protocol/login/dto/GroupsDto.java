package cn.chat.agreement.protocol.login.dto;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class GroupsDto {

    private String groupId;     // 群组ID
    private String groupName;   // 群组名称
    private String groupHead;   // 群组头像

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupHead() {
        return groupHead;
    }

    public void setGroupHead(String groupHead) {
        this.groupHead = groupHead;
    }
}
