package com.qw.common.api.user.api;

import com.qw.common.api.user.entity.User;

/**
 * Created by qinwei on 2019/7/16.
 */
public interface UserApi {

    User findById(Long id);
}
