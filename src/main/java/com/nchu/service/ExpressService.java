package com.nchu.service;

import com.nchu.entity.ExpressDelivery;
import com.nchu.entity.User;

import java.util.List;

/**
 * 2017-9-24 15:48:25
 * 快递表相关业务接口
 */
public interface ExpressService {
    /**
     * TODO 通过名字获取快递方式
     *
     * @param name 快递方式名称
     * @return 快递方式记录
     */
    ExpressDelivery getExpressByName(String name);

    /**
     * TODO 通过id获取快递方式
     *
     * @param id 快递方式id
     * @return 快递方式记录
     */
    ExpressDelivery getExpressById(Long id);

    /**
     * TODO 获取全部快递方式
     *
     * @return 快递方式列表
     */
    List<ExpressDelivery> getExpressDelivery();

    /**
     * TODO 增加快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    boolean addExpress(ExpressDelivery expressDelivery, User operator);

    /**
     * TODO 删除快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    boolean deleteExpress(ExpressDelivery expressDelivery, User operator);

    /**
     * TODO 更新快递方式信息
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    boolean updateExpress(ExpressDelivery expressDelivery, User operator);
}
