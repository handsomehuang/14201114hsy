package com.nchu.exception;

/**
 * 2017-9-25 15:24:41
 * 商品相关异常
 */
public class GoodsException extends ServiceException {
    public GoodsException() {
    }

    public GoodsException(String message) {
        super(message);
    }
}
