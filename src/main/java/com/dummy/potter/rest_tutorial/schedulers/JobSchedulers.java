package com.dummy.potter.rest_tutorial.schedulers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableAsync
public class JobSchedulers {

    @Scheduled(fixedDelay = 5 * 1000)
    @Async
    public void fixedRate1Sch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Job :: 10:: " + strDate);
    }

    @Scheduled(fixedDelay = 10 * 1000)
    @Async
    public void fixedRate5Sch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Job :: 20:: " + strDate);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Job :: 20:: " + strDate+" finished");
    }
}
