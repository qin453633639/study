package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现。
 * @author eacdy
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka {

    public static String  serviceUrl;
    public static void main(String[] args) {
        SpringApplication.run(Eureka.class, args);


    }
}