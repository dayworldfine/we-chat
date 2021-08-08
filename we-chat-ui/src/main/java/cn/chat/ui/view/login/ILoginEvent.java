package cn.chat.ui.view.login;


/**
 * @ClassName：ILoginEvent
 * @Description: 登陆窗口实现，外部给予实现
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public interface ILoginEvent {

    /**
     * 登陆验证
     * @param userId        用户ID
     * @param userPassword  用户密码
     */
    void doLoginCheck(String userId, String userPassword);

}
