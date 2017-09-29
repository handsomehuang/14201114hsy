package com.nchu.dao;

import com.nchu.entity.Order;
import com.nchu.entity.Shop;
import com.nchu.enumdef.OrderStatus;

import java.util.List;

/**
 * 2017年9月20日09:21:32
 * 商品订单Dao接口
 */
public interface OrderDao extends BaseDao<Order, Long> {
    /**
     * 获取一家店铺的全部指定状态订单
     *
     * @param shop        店铺
     * @param orderStatus 订单状态
     * @param page        页码
     * @param pageSize    页面大小,如果小于0则不分页
     * @return 订单列表
     */
    List<Order> getShopOrders(Shop shop, OrderStatus orderStatus, int page, int pageSize);
}
