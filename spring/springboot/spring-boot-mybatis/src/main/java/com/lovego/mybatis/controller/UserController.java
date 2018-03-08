package com.lovego.mybatis.controller;

import com.lovego.mybatis.po.User;
import com.lovego.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@RestController


@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    public User findUserById(@PathVariable int id){
        User u = userService.findUserById(id );
        return u;
    }
}
