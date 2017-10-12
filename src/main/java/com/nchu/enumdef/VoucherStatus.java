package com.nchu.enumdef;

/**
 * 2017-9-27 21:56:014
 * 优惠券相关状态定义
 */
public enum VoucherStatus {
    NORMAL("正常"),
    OVERDUE("过期"),
    DISABLED("失效");
    private String description;

    VoucherStatus(String description) {
        this.description = description;
    }
}
