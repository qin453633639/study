package com.qw.common.api.user.api;

import com.qw.common.api.user.entity.UserAddress;

/**
 * Created by qinwei on 2019/8/24.
 */
public interface UserAddressApi {

    UserAddress findByUserId(long id);
}
