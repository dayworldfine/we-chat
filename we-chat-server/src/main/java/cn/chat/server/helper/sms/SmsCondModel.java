package cn.chat.server.helper.sms;

import java.io.Serializable;

/**
 * @ClassName：SmsCondModel
 * @Description: 短信
 * @Author：13738700108
 * @Data 2021/9/25 10:24
 * @Version: v1.0
 **/
public class SmsCondModel implements Serializable {

    private String code ;
    private Long time;

    public SmsCondModel() {
    }

    public SmsCondModel(String code, Long time) {
        this.code = code;
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
