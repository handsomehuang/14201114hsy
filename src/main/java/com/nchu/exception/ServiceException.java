package com.nchu.exception;

/**
 * Service层统一异常
 */
public class ServiceException extends Throwable {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }
}
