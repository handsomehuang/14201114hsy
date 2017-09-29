package com.nchu.dao;

import java.util.List;

import com.nchu.entity.ExpressDelivery;

/**
 * 2017年9月20日10:14:25
 * 快递表DAO接口
 */
public interface ExpressDeliveryDao extends BaseDao<ExpressDelivery,Long> {
    /**
     * 根据快递名称name，获得该快递对象
     */
    public ExpressDelivery getByName(String name);
}
