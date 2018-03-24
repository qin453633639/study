package com.bestbigbird.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private Object subject;

    /**
     * 构造方法，给我们要代理的真实对象赋初值
     *
     * @param subject
     */
    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(subject, args);
        System.out.println("after");
        return null;
    }

}