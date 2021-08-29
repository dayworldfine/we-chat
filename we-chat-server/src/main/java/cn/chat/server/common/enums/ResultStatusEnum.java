package cn.chat.server.common.enums;

/**
 * @Author wbh
 * @Description result状态码
 * @Date 2021/6/16 16:51
 * @Version: v1.0
 */
public enum ResultStatusEnum {

    /**成功 */
    SUCCESS("0000", "成功"),
    /**未知失败 */
    UN_ERROR("0001", "未知失败"),
    /**非法参数 */
    ILLEGAL_PARAMETER("0002", "非法参数"),
    /**主键冲突 */
    INDEX_DUP("0003", "主键冲突");

    private String code;

    private String message;

    ResultStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
