package com.bestbigbird.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {
    private static  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd : HH-mm-ss");
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(5);
        Task task = new Task(1);
        System.out.println(format.format(new Date()));
        //延迟 delay 时间后，在执行一次任务
        //scheduledExecutorService.schedule(task, 10, TimeUnit.SECONDS);



        // 任务启动后，并且延迟initalDelay时间后，每隔period时间 执行一次；
        // 如果任务执行时间超过间隔，则按实际的为准
        for(int i=0;i<10;i++){
            int x =(int)(Math.random()*10);
            int y =(int)(Math.random()*10);
            scheduledExecutorService.scheduleWithFixedDelay(new Task(x), y, 3, TimeUnit.SECONDS);
        }
        System.out.println(1);
        //scheduledExecutorService.	scheduleWithFixedDelay(task, 10, 3, TimeUnit.SECONDS);
    }

}

class Task implements Runnable{
    public Task(int i) {
        this.i = i;
    }

    private int i;
    private static  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd : HH-mm-ss");
    @Override
    public void run(){
        try {
           /* System.out.println(format.format(new Date()));*/
            Thread.sleep(4000L);
            System.out.println(format.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do task...");
    }
}
