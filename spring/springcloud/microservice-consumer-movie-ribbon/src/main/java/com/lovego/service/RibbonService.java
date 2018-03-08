package com.lovego.service;

import com.common.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/5/22.
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;



    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
    }
}