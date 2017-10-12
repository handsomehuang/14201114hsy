package com.nchu.service.impl;

import com.nchu.entity.Order;
import com.nchu.enumdef.PaymentMethod;
import com.nchu.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * 2017-9-27 16:51:50
 * 第三方支付接口实现类
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 订单支付
     *
     * @param order         要支付的订单
     * @param paymentMethod 支付方式
     * @return 支付结果
     */
    @Override
    public boolean payOrder(Order order, PaymentMethod paymentMethod) {
        return true;
    }

    /**
     * TODO 第三方支付退款
     *
     * @param order         要退款的订单
     * @param paymentMethod 支付方式
     * @return 操作结果
     */
    @Override
    public boolean refund(Order order, PaymentMethod paymentMethod) {
        return true;
    }
}
