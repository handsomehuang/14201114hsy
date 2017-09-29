package com.nchu.dao;

import com.nchu.entity.Goods;
import com.nchu.entity.Saletype;

import java.io.Serializable;
import java.util.List;

/**
 * 2017年9月20日08:31:07
 * 商品DAO接口
 */
public interface GoodsDao extends BaseDao<Goods, Long> {
    /**
     * 下架指定店铺中的全部商品,即更改商品状态为已下架
     *
     * @param shopId 要下架商品的店铺id
     */
    void removeGoodsByShop(Long shopId);

    /**
     * 根据商品关键字模糊查询商品
     *
     * @param keyword 商品关键字
     */
    List<Goods> searchByName(String keyword);

    /**
     * 根据商品关键字模糊查询商品
     *
     * @param keyword 商品关键字
     */
    List<Goods> searchByNamePage(String keyword, int page, int pageSize);
}
