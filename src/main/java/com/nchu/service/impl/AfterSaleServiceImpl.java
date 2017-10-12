package com.nchu.service.impl;

import com.nchu.dao.AfterSaleDao;
import com.nchu.entity.AfterSale;
import com.nchu.entity.User;
import com.nchu.enumdef.AfterSaleStatus;
import com.nchu.enumdef.UserRoleType;
import com.nchu.exception.AfterSaleException;
import com.nchu.service.AfterSaleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2017-9-23 18:17:48 售后服务相关业务实现类
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService {

    @Autowired
    AfterSaleDao asd;

    /**
     * TODO 发起售后请求 若关联的订单id为空则不进行操作
     *
     * @param afterSale 售后请求记录
     * @return 操作结果
     */
    @Override
    public boolean createAfterSale(AfterSale afterSale) throws AfterSaleException {
        if (afterSale.getOrder() == null) {
            throw new AfterSaleException("该订单不存在");
        } else {
            asd.saveOrUpdate(afterSale);
            return true;
        }
    }

    /**
     * TODO 取消售后请求 通过售后对象获取关联订单,然后比对订单所属人是否为操作者 验证通过修改订单状态为取消
     *
     * @param afterSale 售后请求
     * @param operator  操作人
     * @return 操作结果
     */
    @Override
    public boolean cancelService(AfterSale afterSale, User operator) throws AfterSaleException {
        if (afterSale.getOrder().getUser().getId() == operator.getId()) {
            afterSale.setServiceStatus(AfterSaleStatus.SERVICE_CANCEL.getIndex());
            try {
                asd.update(afterSale);
                return true;
            } catch (Exception e) {
                throw new AfterSaleException("取消售后申请异常");
            }
        } else
            throw new AfterSaleException("取消售后申请非法操作者");
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
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("service_status", afterSaleStatus.getIndex());
        return asd.searchPage(conditions, page, pageIndex);
    }

    /**
     * TODO 处理售后请求 校验操作者身份为商家 插入数据前修改afterSale状态为已完成
     *
     * @param afterSale 售后处理结果对象
     * @param operator  操作者
     * @return 操作结果
     */
    @Override
    public boolean handleAfterSale(AfterSale afterSale, User operator) throws AfterSaleException {
        if (Integer.valueOf(operator.getRole()) == UserRoleType.MERCHANT.getIndex()) {
            afterSale.setServiceStatus(AfterSaleStatus.SERVICE_FINISH.getIndex());
            try {
                asd.update(afterSale);
                return true;
            } catch (Exception e) {
                throw new AfterSaleException("售后申请处理状态更新异常");
            }
        } else
            throw new AfterSaleException("售后申请处理非法操作者");
    }
}
