package com.lovego.service;

import com.common.po.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

@FeignClient(name = "microservice-provider-user")
public interface IUserFeignService {
    @RequestMapping("/user/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);
}
