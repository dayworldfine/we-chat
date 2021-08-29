package cn.chat.server.common.enums;

/**
* @Author wbh
* @Description 消息类型枚举
* @Date 11:44 2021/8/29
* @Param
* @return
**/
public enum MsgTypeEnum {

    Myself(0, "自己"),
    Friend(1, "好友");

    private Integer code;
    private String info;

    MsgTypeEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
