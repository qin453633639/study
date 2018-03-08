package com.lovego.controller;

import com.common.po.User;
import com.lovego.service.IUserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@RestController
public class FeignController {
    @Autowired
    private IUserFeignService iUserFeignService;
    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.iUserFeignService.findByIdFeign(id);
        return user;
    }
}
