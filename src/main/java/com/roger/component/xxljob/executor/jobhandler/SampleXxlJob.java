package com.roger.component.xxljob.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleXxlJob {
    private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);
    /**
     * 新建一个test
     */
    @XxlJob("myTestJobHandler")
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("===my TestJobHandler===");
        int t = Integer.valueOf(param);
        for(int i=0; i<t; i++){
            XxlJobLogger.log("=== : " + i);
        }

        return ReturnT.SUCCESS;
    }
}
