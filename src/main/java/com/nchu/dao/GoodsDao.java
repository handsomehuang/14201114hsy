package com.nchu.dao;

import com.nchu.entity.Goods;

import java.io.Serializable;

/**
 * 2017年9月20日08:31:07
 * 商品DAO接口
 */
public interface GoodsDao extends BaseDao<Goods,Long> {
    /**
     * 下架指定店铺中的全部商品,即更改商品状态为已下架
     *
     * @param shopId 要下架商品的店铺id
     */
    void removeGoodsByShop(Serializable shopId);
}
