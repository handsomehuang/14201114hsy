package com.nchu.enumdef;

import java.math.BigDecimal;

/**
 * 2017-9-27 22:57:46
 * 优惠券获取区间定义
 */
public class VoucherPrice {
    public static BigDecimal LEVEL01 = BigDecimal.valueOf(200);
    public static BigDecimal LEVEL02 = BigDecimal.valueOf(400);
    public static BigDecimal LEVEL03 = BigDecimal.valueOf(600);
    public static BigDecimal LEVEL04 = BigDecimal.valueOf(800);
    public static BigDecimal LEVEL05 = BigDecimal.valueOf(1000);
    /*优惠券金额*/
    BigDecimal price;
    /*只要在订单金额达到该限制后才能使用优惠券*/
    BigDecimal limit;

    private VoucherPrice(BigDecimal price, BigDecimal limit) {
        this.price = price;
        this.limit = limit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getLimt() {
        return limit;
    }

    /**
     * 通过给定的商品价格获取优惠券金额
     *
     * @param goodsPrice 商品价格
     * @return 优惠券金额
     */
    public static VoucherPrice getVoucherPrice(BigDecimal goodsPrice) {
        /*判断优惠区间
        * 在LEVEL1 - LEVEL2 之间
        * */
        if (goodsPrice.compareTo(LEVEL01) >= 0 && goodsPrice.compareTo(LEVEL02) == -1) {
            return new VoucherPrice(BigDecimal.valueOf(5), LEVEL01);
            /*大于等于等级二,小于等级三*/
        } else if (goodsPrice.compareTo(LEVEL02) >= 0 && goodsPrice.compareTo(LEVEL03) == -1) {
            return new VoucherPrice(BigDecimal.valueOf(10), LEVEL02);
        } else if (goodsPrice.compareTo(LEVEL03) >= 0 && goodsPrice.compareTo(LEVEL04) == -1) {
            return new VoucherPrice(BigDecimal.valueOf(25), LEVEL03);
        } else if (goodsPrice.compareTo(LEVEL04) >= 0 && goodsPrice.compareTo(LEVEL05) == -1) {
            return new VoucherPrice(BigDecimal.valueOf(50), LEVEL04);
        } else {
            return new VoucherPrice(BigDecimal.valueOf(100), LEVEL05);
        }
    }
}