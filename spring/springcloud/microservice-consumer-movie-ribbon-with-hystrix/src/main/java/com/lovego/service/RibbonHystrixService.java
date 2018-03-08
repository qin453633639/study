package com.lovego.service;

import com.common.po.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@Service

public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        User u = this.restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
        return  u;

    }

    public User fallback(Long id) {
        RibbonHystrixService.LOGGER.info("异常发⽣，进⼊fallback⽅法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1);
        user.setName("0000000xxxxxxxx");
        user.setAge(0);
        return user;
    }

}
