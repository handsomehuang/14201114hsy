package com.nchu.exception;

/**
 * 2017-9-25 15:03:54
 * 订单相关业务层异常
 */
public class OrderException extends ServiceException {

    public OrderException() {
    }


    public OrderException(String message) {
        super(message);
    }
}
