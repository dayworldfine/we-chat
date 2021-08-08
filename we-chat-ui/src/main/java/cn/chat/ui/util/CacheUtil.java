package cn.chat.ui.util;


import cn.chat.ui.view.chat.element.group_bar_chat.ElementTalk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class CacheUtil {

    // 对话框组
    public static Map<String, ElementTalk> talkMap = new ConcurrentHashMap<String, ElementTalk>(16);

}
