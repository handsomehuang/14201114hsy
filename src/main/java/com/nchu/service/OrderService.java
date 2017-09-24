package com.nchu.service;

import com.nchu.entity.Goods;
import com.nchu.entity.Order;
import com.nchu.entity.OrderStatus;
import com.nchu.entity.User;

import java.util.List;

/**
 * 2017-9-23 18:12:02
 * 订单相关业务接口
 */
public interface OrderService {
    /**
     * TODO　创建订单
     * 　新创建订单默认为未支付订单
     *
     * @param order 　订单实体
     * @return 操作结果
     */
    boolean createOrder(Order order);

    /**
     * TODO 获取用户指定状态的全部订单
     *
     * @param user     用户
     * @param status   订单状态
     * @param page     页码
     * @param pageSize 页面大小
     * @return 订单列表
     */
    List<Order> listUserOrders(User user, OrderStatus status, int page, int pageSize);

    /**
     * TODO 订单支付
     * 判断用户余额,支付成功修改订单状态为已支付,发送系统消息通知商家
     *
     * @param order 待支付的订单
     * @param user  用户
     * @return 操作结果
     */
    boolean payment(Order order, User user);

    /**
     * TODO 交易取消
     * 判断订单状态,只有未支付\未收货的订单可以取消
     * 订单用户需与操作者相同,取消完成后返回用户支付金额
     *
     * @param order    要取消的订单
     * @param operator 操作者
     * @return 操作结果
     */
    boolean orderCancel(Order order, User operator);

    /**
     * TODO 取消所有某一件商品的已支付但未收货订单
     * 通过Order表的goodsId查询,全部购买了某商品且订单状态为已支付但未收货状态的用户,
     * 用于团购活动失败或取消后的统一订单处理,订单取消后需要返回所有用户的支付金额
     *
     * @param goods 商品,至少包含商品id
     * @return 操作结果
     */
    boolean cancelAllOrder(Goods goods);

    /**
     * TODO 订单退款
     *
     * @param orderList 要退款的订单列表
     * @return 操作结果
     */
    boolean refund(List<Order> orderList);

}
