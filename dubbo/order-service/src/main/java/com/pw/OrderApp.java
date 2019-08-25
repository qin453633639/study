package com.pw;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class OrderApp {
    private static Object object = new Object();
    public static void main( String[] args ) throws InterruptedException {
        synchronized (object){
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            object.wait();
        }

    }
}
