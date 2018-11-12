package spring.entity;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * Created by qinwei on 2018/1/13.
 */


public class Student  implements Lifecycle,DisposableBean {
    private String age;


    public Student(){

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("SmartLifecycle stop()");
    }*/


    public void start() {
        System.out.println("Lifecycle start()");
    }


    public void stop() {
        System.out.println("Lifecycle stop");
    }


    public boolean isRunning() {
        return false;
    }

    /*@Override
    public int getPhase() {
        return 2;
    }*/


    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    public void initDestroy(){
        System.out.println("initDestroy destroy");
    }
}
