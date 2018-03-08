package com.lovego.provider.controller;

import com.common.po.User;
import com.lovego.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    public User findUserById(@PathVariable int id){
        System.out.println(111111);
        User u = userService.findUserById(id );
        return u;
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

}
