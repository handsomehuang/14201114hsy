package com.nchu.dao;

import com.nchu.entity.Shop;
import com.nchu.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017年9月20日08:12:55
 * 商店DAO接口
 */
public interface ShopDao extends BaseDao<Shop, Long> {

    /**
     * 根据User对象获得店铺对象，User对象为商家
     *
     * @param model 要查询的用户
     * @return 店铺
     */
    Shop getByUser(User model);

    /**
     * 分页查询店铺
     *
     * @param keyword  查询关键词,如果关键词为空执行全部查询
     * @param page     页码
     * @param pageSize 每页大小
     * @return 查询结果列表
     */
    List<Shop> searchShop(String keyword, int page, int pageSize);
}
