package com.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by qinwei on 2018/11/12.
 */
public class JavassistProxyFactory implements ProxyFactory{

    @Override
    public <T> T getProxy(Object target, InvocationHandler handler) throws Throwable {
        return (T) ProxyGenerator.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass(), handler);
    }


}
