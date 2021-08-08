package cn.chat.ui.view.chat.data;


/**
 * @ClassName：GroupsData
 * @Description: 群组数据(ElementFriendGroup)
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class GroupsData {

    private String groupId;    // 群组ID
    private String groupName;  // 群组名称
    private String groupHead;  // 群组头像

    public GroupsData() {
    }

    public GroupsData(String groupId, String groupName, String groupHead) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupHead = groupHead;
    }

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
