package com.pw.user.service;

import com.qw.common.api.user.api.UserAddressApi;
import com.qw.common.api.user.entity.UserAddress;
import org.springframework.stereotype.Service;

/**
 * Created by qinwei on 2019/8/24.
 */
@Service("useraddress")
public class UserAddressServiceImpl implements UserAddressApi  {
    @Override
    public UserAddress findByUserId(long id) {
        return new UserAddress("湖南","常德","桃园");
    }
}
