package com.nchu.exception;

/**
 * 团购相关异常
 */
public class GroupPurchaseException extends ServiceException {
    public GroupPurchaseException() {
    }

    public GroupPurchaseException(String message) {
        super(message);
    }
}
