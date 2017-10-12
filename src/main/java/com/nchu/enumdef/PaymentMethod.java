package com.nchu.enumdef;

/**
 * 2017-9-27 16:42:32
 * 支付方式枚举常量
 */
public enum PaymentMethod {
    ACCOUNT("账户余额支付"),
    BANK_CARD("银行卡支付"),
    ALI_PAY("支付宝支付"),
    OTHER("其他支付方式");

    private String discription;

    PaymentMethod(String discription) {
        this.discription = discription;
    }

    public String getDiscription() {
        return discription;
    }
}
