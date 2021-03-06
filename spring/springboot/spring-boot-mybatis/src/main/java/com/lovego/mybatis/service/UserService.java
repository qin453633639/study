package com.lovego.mybatis.service;

import com.lovego.mybatis.mapper.UserMapper;
import com.lovego.mybatis.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper ;

    public User findUserById(int id){
        return userMapper.findUserById(id);
    }
}
