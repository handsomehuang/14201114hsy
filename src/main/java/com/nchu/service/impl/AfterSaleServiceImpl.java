package com.nchu.service.impl;

import com.nchu.entity.AfterSale;
import com.nchu.entity.User;
import com.nchu.enumdef.AfterSaleStatus;
import com.nchu.service.AfterSaleService;

import java.util.List;

/**
 * 2017-9-23 18:17:48
 * 售后服务相关业务实现类
 */
public class AfterSaleServiceImpl implements AfterSaleService {
    /**
     * TODO 发起售后请求
     * 若关联的订单id为空则不进行操作
     *
     * @param afterSale 售后请求记录
     * @return 操作结果
     */
    @Override
    public boolean createAfterSale(AfterSale afterSale) {
        return false;
    }

    /**
     * TODO 取消售后请求
     * 通过售后对象获取关联订单,然后比对订单所属人是否为操作者
     * 验证通过修改订单状态为取消
     *
     * @param afterSale 售后请求
     * @param operator  操作人
     * @return 操作结果
     */
    @Override
    public boolean cancelService(AfterSale afterSale, User operator) {
        return false;
    }

    /**
     * TODO 列出指定条件的售后记录
     *
     * @param afterSaleStatus 售后请求状态
     * @param page            页码
     * @param pageIndex       每页大小
     * @return 售后请求记录
     */
    @Override
    public List<AfterSale> listAfterSale(AfterSaleStatus afterSaleStatus, int page, int pageIndex) {
        return null;
    }

    /**
     * TODO 处理售后请求
     * 校验操作者身份为商家
     * 插入数据前修改afterSale状态为已完成
     *
     * @param afterSale 售后处理结果对象
     * @param operator  操作者
     * @return 操作结果
     */
    @Override
    public boolean handleAfterSale(AfterSale afterSale, User operator) {
        return false;
    }
}
