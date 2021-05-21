package com.mmdz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: MMDZ
 * @Date: 2021/5/20
 * @Desc: 定时任务类TestTimer
 */
@Component
public class TestTimer {

    /* 一秒钟执行一次  cron表达式（http://cron.qqe2.com/）*/
    @Scheduled(cron = "0/1 * * * * ?")
    private void test() {
        System.out.println("执行定时任务的时间是："+new Date());
    }

}
