package spring.entity;


import org.springframework.context.SmartLifecycle;

/**
 * Created by qinwei on 2018/1/13.
 */


public class Student  implements SmartLifecycle {
    private String hello;
    public Student(){

    }


    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {
        System.out.println("student start()");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 2;
    }
}
