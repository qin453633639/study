package com.bestbigbird.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyClient {
    public static void main(String[] args) {
        Car  car = new MyCar();
        InvocationHandler hander = new InvocationHandlerImpl(car);
        ClassLoader loader = car.getClass().getClassLoader();
        Class[] interfaces = car.getClass().getInterfaces();
        Car proxyCar = (Car) Proxy.newProxyInstance(loader,interfaces, hander);
        proxyCar.run();

        try {
            byte[] proxyClass = ProxyGenerator.generateProxyClass(car.getClass()
                    .getSimpleName(), car.getClass().getInterfaces());
            //将字节码文件保存到D盘，文件名为$Proxy0.class
            FileOutputStream outputStream = new FileOutputStream(new File(
                    "d:\\$Proxy0.class"));
            outputStream.write(proxyClass);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





