package com.pw.user.service;

import com.qw.common.api.order.api.OrderApi;
import com.qw.common.api.order.entity.Order;
import com.qw.common.api.user.api.UserApi;
import com.qw.common.api.user.entity.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qinwei on 2019/7/16.
 */

@Service("userService")
public class UserServiceImpl implements UserApi {

    @Autowired
    private OrderApi orderApi;

    @Override
    public User findById(Long id) {
        User u = new User();
        u.setId(id);
        u.setAge(15);
        u.setName("张飒");
       Order order = orderApi.findByUserId(id);
        return u;
    }
}
