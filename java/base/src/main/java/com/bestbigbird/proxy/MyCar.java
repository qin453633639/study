package com.bestbigbird.proxy;

public class  MyCar implements  Car {
    @Override
    public void run(){
        System.out.println("mycat is run");

    }
    @Override
    public void stop(){
        System.out.println("mycat is stop");

    }
}