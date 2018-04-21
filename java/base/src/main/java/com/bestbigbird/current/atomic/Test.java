package com.bestbigbird.current.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {

        AtomicInteger atomicInteger=  new AtomicInteger(100);
        atomicInteger.incrementAndGet();


    }
}

class MyRunable implements  Runnable{
    public static AtomicInteger atomicInteger=  new AtomicInteger(100);
    public static int x = 100;
    @Override
    public void run() {

        atomicInteger.incrementAndGet();


    }
}
