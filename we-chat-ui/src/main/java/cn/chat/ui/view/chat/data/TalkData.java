package cn.chat.ui.view.chat.data;

/**
 * @ClassName：TalkData
 * @Description: 对话框用户数据
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class TalkData {

    private String talkName;
    private String talkHead;

    public TalkData(){}

    public TalkData(String talkName, String talkHead) {
        this.talkName = talkName;
        this.talkHead = talkHead;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public String getTalkHead() {
        return talkHead;
    }

    public void setTalkHead(String talkHead) {
        this.talkHead = talkHead;
    }

}
