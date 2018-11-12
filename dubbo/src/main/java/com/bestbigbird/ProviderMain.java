package com.bestbigbird;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.bestbigbird.dubbo.provide.IUserService;
import com.bestbigbird.dubbo.provide.impl.UserServicerImpl;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Hello world!
 */
public class ProviderMain {
    private static Object LOCK = new Object();
    public static void main(String[] args) {
        try {
            synchronized(LOCK){
                start();
                LOCK.wait(); //等待，直到其它线程调用 lock.notify()
            }
        }catch (Exception e){
                e.printStackTrace();
        }


    }
    public static void start() {

        // 服务实现
        IUserService testService = new UserServicerImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-api-test");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("119.23.36.49:2181");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12345);
        protocol.setThreads(100);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        ServiceConfig<IUserService> service = new ServiceConfig<IUserService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(IUserService.class);
        service.setRef(testService);
        service.setVersion("1.0.0");
        // 暴露及注册服务
        service.export();
    }

}
