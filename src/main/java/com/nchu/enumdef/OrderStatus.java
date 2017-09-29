package com.nchu.enumdef;

/**
 * 2017年9月20日15:14:56
 * 订单状态枚举常量
 *
 * @author xjw
 */
public enum OrderStatus {
    ORDER_READY("订单创建已就绪，部分信息未补全"),
    ORDER_UNPAY("订单创建成功，但还未完成支付"),
    ORDER_TIMEOUT("订单已创建，超时未支付"),
    ORDER_PAY("订单已创建，支付成功"),
    ORDER_SENDOUT("订单已发货"),
    ORDER_CANCEL("订单创建成功，用户主动取消"),
    ORDER_WAITING_REFUNFD("订单已支付，用户提交退款申请"),
    ORDER_REFUND_FAIL("用户提交退款申请，退款失败"),
    ORDER_REFUND_TIMEOUT("用户提交退款申请，商家超时未处理，此时转到管理员处理"),
    ORDER_REFUND("退款操作成功"),
    ORDER_WAITING_RECEVE("订单已支付，等待用户收货确认"),
    ORDER_SUCCESS("订单交易成功"),
    ORDER_INVALIDATION("无效订单"),
    ORDER_EXCEPTION("异常订单");
    /*状态描述*/
    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
