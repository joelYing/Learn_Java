package com.example.advance;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/26 10:55
 **/
public class QuartzExample {
    public static void main(String[] args) throws SchedulerException {
        // 任务调度
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job", "group")
                .usingJobData("id", 1)
                .usingJobData("name", "yjl")
                .build();

        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger", "group")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown(true);
    }
}
