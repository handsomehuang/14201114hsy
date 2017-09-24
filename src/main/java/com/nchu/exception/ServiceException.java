package com.nchu.exception;

/**
 * 2017-9-22 10:48:25
 * 业务层异常统一接口
 */
public abstract class ServiceException extends Exception {
    public ExceptionCode exceptionCode;

    public abstract ExceptionCode getExceptionCode();

    public abstract void setExceptionCode(ExceptionCode exceptionCode);
}
