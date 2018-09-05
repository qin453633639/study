package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAopOne {
    @Pointcut("execution(* *.count(..))")
    public void one(){

    }

    @Before("one()")
    public void before(){
        System.out.println("before");
    }

    @After("one()")
    public void after(){
        System.out.println("after");
    }
}
