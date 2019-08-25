package com.pw.order;

import com.qw.common.api.order.api.OrderApi;
import com.qw.common.api.order.entity.Order;
import org.springframework.stereotype.Service;

/**
 * Created by qinwei on 2019/8/24.
 */
@Service("orderservice")
public class OrderServiceImpl implements OrderApi {
    @Override
    public Order findByUserId(Long userId) {
        Order order = new Order();
        order.setId(100L);
        order.setBuerId(userId);
        order.setMoney(10.3);
        return order;
    }
}
