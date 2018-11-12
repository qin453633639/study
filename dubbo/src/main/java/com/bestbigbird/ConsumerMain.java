package com.bestbigbird;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.bestbigbird.dubbo.provide.IUserService;
import com.qw.base.entity.User;
import com.qw.base.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwei on 2018/9/20.
 */
public class ConsumerMain {
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
    public static void start( ) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-api-test-consumer");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("119.23.36.49:2181");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接


        // 引用远程服务 两种办法
        //one 通过这测中心发现服务
        ReferenceConfig<UserService> reference = new ReferenceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(UserService.class);
        reference.setVersion("1.0");

        //two 直连，不通过注册中心发现服务
        /*ReferenceConfig<IUserService> reference = new ReferenceConfig<IUserService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        // 如果点对点直连，可以用reference.setUrl()指定目标地址，设置url后将绕过注册中心，
        // 其中，协议对应provider.setProtocol()的值，端口对应provider.setPort()的值，
        // 路径对应service.setPath()的值，如果未设置path，缺省path为接口名
         reference.setApplication(application);
        reference.setInterface(IUserService.class);
        reference.setVersion("1.0.0");
        reference.setUrl("dubbo://127.0.0.1:12345/com.bestbigbird.dubbo.provide.IUserService");*/


        // 方法级配置
        /** 单独设置某个方法的属性
        <dubbo:reference interface="com.xxx.XxxService">
            <dubbo:method name="findXxx" timeout="3000" retries="2" />
        </dubbo:reference>

        List<MethodConfig> methods = new ArrayList<MethodConfig>();
        MethodConfig method = new MethodConfig();
        method.setName("getName");
        method.setTimeout(10000);
        method.setRetries(0);
        methods.add(method);
         reference.setMethods();
         */




        // 和本地bean一样使用xxxService
        UserService testService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        User u = new User();
        u.setUserName("秦始皇");
         testService.insert(u);
        reference.destroy();
        System.out.println(u);

    }
}
