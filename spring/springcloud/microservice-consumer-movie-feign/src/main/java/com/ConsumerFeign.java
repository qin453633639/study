package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign.class, args);
    }
}
