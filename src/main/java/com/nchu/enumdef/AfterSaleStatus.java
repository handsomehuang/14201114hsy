package com.nchu.enumdef;

/**
 * 2017-9-24 09:12:02
 * 订单售后请求状态枚举常量
 */
public enum AfterSaleStatus {
    /*请求已提交*/
    REQUEST_SUBMIT(1),
    /*处理超时*/
    TIMEOUT(2),
    /*用户取消*/
    SERVICE_CANCEL(3),
    /*处理完成*/
    SERVICE_FINISH(4);
    private int index;

    AfterSaleStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
