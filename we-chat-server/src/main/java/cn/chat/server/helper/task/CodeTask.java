package cn.chat.server.helper.task;

import cn.chat.server.helper.sms.SmsCondModel;
import cn.chat.server.helper.sms.SmsUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description: 验证码定时任务
 * @Author： wbh
 * @Data 2021/8/18 9:47
 * @Version: v1.0
 **/
@Component
public class CodeTask implements ApplicationRunner {

    protected final Logger log = LoggerFactory.getLogger(CodeTask.class);

    public static final String CLEAN_MAP = "0 */1 * * * *";

    @Override
    public void run(ApplicationArguments args)  {
        String scheduleId = CronUtil.schedule(CLEAN_MAP, new Task() {
            @Override
            public void execute() {
                Iterator<Map.Entry<String, SmsCondModel>> iterator = SmsUtil.map.entrySet().iterator();
                long timeMillis = System.currentTimeMillis();
                while (iterator.hasNext()){
                    Map.Entry<String, SmsCondModel> nextMap = iterator.next();
                    if ((nextMap.getValue().getTime()+1000*60*5)<timeMillis){
                        log.info("删除验证码的手机号为:{}",nextMap.getKey());
                        iterator.remove();
                    }
                }
            }
        });
    }
}
