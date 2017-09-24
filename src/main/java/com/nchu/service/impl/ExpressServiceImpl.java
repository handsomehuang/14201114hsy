package com.nchu.service.impl;

import com.nchu.entity.ExpressDelivery;
import com.nchu.entity.User;
import com.nchu.service.ExpressService;

import java.util.List;
/**
 * 2017-9-24 15:48:25
 * 快递表相关业务接口实现类
 */
public class ExpressServiceImpl implements ExpressService{
    /**
     * TODO 通过名字获取快递方式
     *
     * @param name 快递方式名称
     * @return 快递方式记录
     */
    @Override
    public ExpressDelivery getExpressByName(String name) {
        return null;
    }

    /**
     * TODO 通过id获取快递方式
     *
     * @param id 快递方式id
     * @return 快递方式记录
     */
    @Override
    public ExpressDelivery getExpressById(Long id) {
        return null;
    }

    /**
     * TODO 获取全部快递方式
     *
     * @return 快递方式列表
     */
    @Override
    public List<ExpressDelivery> getExpressDelivery() {
        return null;
    }

    /**
     * TODO 增加快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean addExpress(ExpressDelivery expressDelivery, User operator) {
        return false;
    }

    /**
     * TODO 删除快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean deleteExpress(ExpressDelivery expressDelivery, User operator) {
        return false;
    }

    /**
     * TODO 更新快递方式信息
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean updateExpress(ExpressDelivery expressDelivery, User operator) {
        return false;
    }
}
