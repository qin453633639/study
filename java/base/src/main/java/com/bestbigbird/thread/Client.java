package com.bestbigbird.thread;

import java.util.concurrent.*;

public class Client {
    /**
     *
     * ThreadPoolExecutor(
     int corePoolSize, // 线程池维护线程的最少数量
     int maximumPoolSize, // 线程池维护线程的最大数量
     long keepAliveTime, // 线程池维护线程所允许的空闲时间
     TimeUnit unit, // 线程池维护线程所允许的空闲时间的单位
     BlockingQueue<Runnable> workQueue, // 线程池所使用的缓冲队列
     ThreadFactory threadFactory, RejectedExecutionHandler handler // 线程池对拒绝任务的处理策略
     )


     * 1. 线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。

     2. 当调用 execute() 方法添加一个任务时，线程池会做如下判断：

     a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
     b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列；
     c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
     d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常。

     3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。

     4. 当一个线程空闲，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。
     * @param args
     */
    public static void main(String[] args) {
       /* ExecutorService fixedThreadPool =  new ThreadPoolExecutor(1,2,2,null,null);*/
        /*int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
        //拒绝策略1：将抛出 RejectedExecutionException.
        RejectedExecutionHandler handler =
                new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (corePoolSize, maxPoolSize,
                        keepAliveTime, TimeUnit.SECONDS,
                        queue, handler);
        for(int i=0; i<100; i++) {
            try {
                executor.execute(new Worker(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        executor.shutdown();*/
        byte a = (byte)127;
        byte b = (byte)1;
        System.out.println((byte)(a+b));

    }


    private static class Worker implements Runnable {
        int i;
        public Worker(int i ){
            this.i = i;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  "+i + " is running");
        }
    }



}
