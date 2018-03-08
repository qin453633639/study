package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser.class, args);


    }
}
