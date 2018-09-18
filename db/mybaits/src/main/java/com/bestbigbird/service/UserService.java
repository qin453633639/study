package com.bestbigbird.service;

import com.bestbigbird.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qinwei on 2018/9/18.
 */
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void aa() throws Exception {
        userMapper.findById(3);
    }

}
