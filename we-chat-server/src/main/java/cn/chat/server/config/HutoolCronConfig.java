package cn.chat.server.config;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.Scheduler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hutool定时器启动配置
 */
@Configuration
public class HutoolCronConfig {
    @Bean
    public Scheduler start() {
        //匹配秒的部分
        CronUtil.setMatchSecond(true);
        //参数为false表示,主线程一直不退出,如果退出了,就无法执行调度任务了
        CronUtil.start(false);
        return CronUtil.getScheduler();
    }
}
