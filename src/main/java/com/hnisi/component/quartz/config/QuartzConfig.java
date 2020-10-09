package com.hnisi.component.quartz.config;

import com.hnisi.component.quartz.jobbean.SimpleJob;
import org.quartz.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * quartz配置中心
 *
 * @author Roger
 * @since 2020/10/10
 */
@Configuration
public class QuartzConfig {

    private static final String DEFAULT_IDENTITY = "defaultIdentity";

    @Bean
    JobDetail teatQuartzDetail() {
        return JobBuilder.newJob(SimpleJob.class)//SimpleJob我们的业务类
                .withIdentity(DEFAULT_IDENTITY)//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello Quartz")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetai
                .build();
    }

    @Bean
    //设置不加载该bean（matchIfMissing = false）
    @ConditionalOnProperty(prefix = "quartz", name = "auth-open", havingValue = "true", matchIfMissing = false)
    public Trigger testQuartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)
                .repeatForever();// 设置时间周期单位秒 每隔两秒实行一次
        // 设置cron表达式 每隔两秒实行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())//关联上述的JobDetail
                .withIdentity(DEFAULT_IDENTITY)////给Trigger起个名字
                .withSchedule(cronScheduleBuilder).build();

    }
}
