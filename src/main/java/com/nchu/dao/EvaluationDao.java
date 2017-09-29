package com.nchu.dao;

import com.nchu.entity.Evaluation;
import com.nchu.entity.Goods;

/**
 * 2017年9月20日10:03:54
 * 评论表DAO接口
 */
public interface EvaluationDao extends BaseDao<Evaluation,Long> {
    /**
     * 根据商品对象删除所有关于该商品的评论
     */
    public void deleteAllByGoods(Goods model);
}
