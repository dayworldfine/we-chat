package cn.chat.server.common.enums;

/**
 * @ClassName：TalkTypeEnum
 * @Description: 分类
 * @Author：13738700108
 * @Data 2021/8/29 11:31
 * @Version: v1.0
 **/
public enum  TalkTypeEnum {

    Friend(0, "好友"),
    Group(1, "群组");

    private Integer code;
    private String message;

    TalkTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
