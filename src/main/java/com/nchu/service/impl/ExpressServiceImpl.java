package com.nchu.service.impl;

import com.nchu.dao.ExpressDeliveryDao;
import com.nchu.entity.ExpressDelivery;
import com.nchu.entity.User;
import com.nchu.enumdef.UserRoleType;
import com.nchu.exception.ExpressException;
import com.nchu.service.ExpressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 2017-9-24 15:48:25
 * 快递表相关业务接口实现类
 */
@Service
public class ExpressServiceImpl implements ExpressService{

    @Autowired
    ExpressDeliveryDao edd;

    /**
     * TODO 通过名字获取快递方式
     *
     * @param name 快递方式名称
     * @return 快递方式记录
     */
    @Override
    public ExpressDelivery getExpressByName(String name) {
        return edd.getByName(name);
    }

    /**
     * TODO 通过id获取快递方式
     *
     * @param id 快递方式id
     * @return 快递方式记录
     */
    @Override
    public ExpressDelivery getExpressById(Long id) {
        return edd.get(id);
    }

    /**
     * TODO 获取全部快递方式
     *
     * @return 快递方式列表
     */
    @Override
    public List<ExpressDelivery> getExpressDelivery() {
        return edd.listAll();
    }

    /**
     * TODO 增加快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean addExpress(ExpressDelivery expressDelivery, User operator) throws ExpressException {
        if (Integer.valueOf(operator.getRole()) == UserRoleType.ADMIN.getIndex()) {
            try {
                edd.save(expressDelivery);
                return true;
            } catch (Exception e) {
                throw new ExpressException("增加快递异常");
            }
        } else
            throw new ExpressException("增加快递非法操作者");
    }

    /**
     * TODO 删除快递方式
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean deleteExpress(ExpressDelivery expressDelivery, User operator) throws ExpressException {
        if (Integer.valueOf(operator.getRole()) == UserRoleType.ADMIN.getIndex()) {
            try {
                edd.deleteObject(expressDelivery);
                return true;
            } catch (Exception e) {
                throw new ExpressException("删除快递异常");
            }
        } else
            throw new ExpressException("删除快递非法操作者");
    }

    /**
     * TODO 更新快递方式信息
     *
     * @param expressDelivery 快递记录对象
     * @param operator        操作员,限定管理员
     * @return 操作结果
     */
    @Override
    public boolean updateExpress(ExpressDelivery expressDelivery, User operator) throws ExpressException {
        if (Integer.valueOf(operator.getRole()) == UserRoleType.ADMIN.getIndex()) {
            try {
                edd.update(expressDelivery);
                return true;
            } catch (Exception e) {
                throw new ExpressException("更新快递异常");
            }
        } else
            throw new ExpressException("更新快递非法操作者");
    }
}
