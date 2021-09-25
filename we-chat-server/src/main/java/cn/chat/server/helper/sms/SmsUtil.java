package cn.chat.server.helper.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName：SmsUtil
 * @Description: 短信工具类
 * @Author：13738700108
 * @Data 2020/10/6 19:11
 * @Version: v1.0
 **/
public class SmsUtil {

    public static Map<String,SmsCondModel>  map = new ConcurrentHashMap<>();

    public static String regionId = "cn-hangzhou";

    public static String SignName = "Tom";

    public static String TemplateCode = "SMS_172887101";

    public static String accessKeyId = "LTAIugLGMMRE80v9";

    public static String secret = "bLmjLAOpVXUKoPLCOQXbbY27Vh3VPX";


    /**
     * 产生6位数的随机验证码
     * @return
     */
    public static String generalRandomVeriCode(){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            int random=(int)(Math.random()*9+1);
            System.out.println(random);
            sb.append(random);
        }
        return sb.toString();
    }
}
