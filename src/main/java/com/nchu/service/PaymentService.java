package com.nchu.service;

import com.nchu.entity.Order;
import com.nchu.enumdef.PaymentMethod;

/**
 * 2017-9-27 16:47:17
 * 第三方支付接口
 */
public interface PaymentService {
    /**
     * TODO 第三方订单支付
     *
     * @param order         要支付的订单
     * @param paymentMethod 支付方式
     * @return 支付结果
     */
    boolean payOrder(Order order, PaymentMethod paymentMethod);

    /**
     * TODO 第三方支付退款
     *
     * @param order         要退款的订单
     * @param paymentMethod 支付方式
     * @return 操作结果
     */
    boolean refund(Order order, PaymentMethod paymentMethod);
}
