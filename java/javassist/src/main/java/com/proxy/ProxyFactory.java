package com.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by qinwei on 2018/11/12.
 */
public interface ProxyFactory {
    <T> T getProxy(Object target, InvocationHandler handler) throws Throwable;

}
