package com.bestbigbird.current;

import java.util.concurrent.Semaphore;

/**
 * Created by qinwei on 2018/9/15.
 */
public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10, true);

        for (int i=0;i<20;i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(1);

                    Thread.sleep(30000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
