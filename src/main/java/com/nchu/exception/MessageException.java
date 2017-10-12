package com.nchu.exception;

/*消息相关异常*/
public class MessageException extends ServiceException {
    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }
}
