package com.bestbigbird.dubbo.provide.impl;

import com.bestbigbird.dubbo.provide.IUserService;

import java.util.List;

/**
 * Created by qinwei on 2018/9/19.
 */
public class UserServicerImpl implements IUserService {

    @Override
    public String getName(Integer a) {
        return "111";
    }

    @Override
    public int getAget(String c) {
        return 10;
    }

    @Override
    public String getAddre(List a) {
        return "asdfaf";
    }
}
