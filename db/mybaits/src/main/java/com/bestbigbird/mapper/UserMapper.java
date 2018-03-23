package com.bestbigbird.mapper;

import com.bestbigbird.entity.User;



/**
 * Created by qinwei on 2018/3/23.
 */
public interface UserMapper {

    //根据用户名列模糊查询用户列表
    public User findById(Integer id)throws Exception;

}