package cn.chat.ui.view.register;

/**
 * @ClassName：RegisterMethod
 * @Description: 窗口方法，给予外部调用
 * @Author：13738700108
 * @Data 2021/9/20 14:40
 * @Version: v1.0
 **/
public interface IRegisterMethod {

    /**
     * 打开注册窗口
     */
    void doShow();

    /**
     * 发送短信倒计时
     */
    void countDown(String time);

    /**
     * 注册成功
     */
    void registerSuccess();

    /**
     * 注册失败
     */
    void registerError(String msg);
}
