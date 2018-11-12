package com;

import com.proxy.JavassistProxyFactory;
import com.proxy.ProxyFactory;
import com.service.HelloService;
import com.service.HelloServiceImpl;
import javassist.ClassMap;
import javassist.ClassPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Throwable {
        ProxyFactory factory = factory = new JavassistProxyFactory();
        HelloService helloService = new HelloServiceImpl();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //打印日志
                System.out.println("[before] The method " + methodName + " begins");
                Object result = null;
                try{
                    //前置通知
                    result = method.invoke(helloService, args);
                    //返回通知, 可以访问到方法的返回值
                    System.out.println(String.format("after method:%s execute", method.getName()));
                } catch (Exception e){
                    e.printStackTrace();
                    //异常通知, 可以访问到方法出现的异常
                }
                //后置通知. 因为方法可以能会出异常, 所以访问不到方法的返回值
                //打印日志
                System.out.println("[after] The method ends with " + result);
                return result;
            }
        };

        HelloService proxy = factory.getProxy(helloService, handler);

        proxy.print("qqq");

        System.out.println(proxy.getAddress());
    }
}
