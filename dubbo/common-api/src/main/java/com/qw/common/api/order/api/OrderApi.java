package com.qw.common.api.order.api;

import com.qw.common.api.order.entity.Order;

/**
 * Created by qinwei on 2019/8/24.
 */
public interface OrderApi {

    Order findByUserId(Long userId);
}
