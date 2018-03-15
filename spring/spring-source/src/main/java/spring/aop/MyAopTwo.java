package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopTwo {
    @Pointcut("execution(* *.count(..))")
    public void one(){

    }

    @Before("one()")
    public void before(){
        System.out.println("Twobefore");
    }

    @After("one()")
    public void after(){
        System.out.println("Twoafter");
    }
}
