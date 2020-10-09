package com.hnisi.component.quartz.jobbean;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * quartz 测试bean
 *
 * @author Roger
 * @since 2020/10/10
 */
public class SimpleJob extends QuartzJobBean {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //获取JobDetail中关联的数据
        String msg = (String) context.getJobDetail().getJobDataMap().get("msg");
        System.out.println("任务执行的时间：" + dateFormat.format(new Date())+"-----"+msg);
    }

}
