package com.nchu.exception;

/**
 * 2017-9-25 15:13:32
 * 售后服务异常
 */
public class AfterSaleException extends ServiceException {
    public AfterSaleException() {
    }

    public AfterSaleException(String message) {
        super(message);
    }
}
