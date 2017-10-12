package com.nchu.exception;

/**
 * 2017-9-25 14:26:01
 * 用户Service层异常
 */
public class UserServiceException extends ServiceException {

    public UserServiceException() {
    }


    public UserServiceException(String message) {
        super(message);
    }
}
