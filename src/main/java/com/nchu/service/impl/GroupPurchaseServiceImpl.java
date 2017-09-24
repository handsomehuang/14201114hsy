package com.nchu.service.impl;

import com.nchu.entity.GroupPurchase;
import com.nchu.entity.Saletype;
import com.nchu.entity.User;
import com.nchu.service.GroupPurchaseService;

import java.util.List;

/**
 * 2017-9-23 18:14:55
 * 团购活动相关业务接口实现类
 */
public class GroupPurchaseServiceImpl implements GroupPurchaseService {
    /**
     * TODO 创建团购活动
     * 校验团购活动实体的user对象是否为商家
     * 团购活动时间有效性检查
     * 插入数据成功后按团购活动截止定时设置定时任务,
     * 活动截止后自动将活动设置为无效
     * 团购活动开始后自动给所有订阅用户发送提醒邮件
     *
     * @param groupPurchase 团购活动
     * @return 操作结果
     */
    @Override
    public boolean createGroup(GroupPurchase groupPurchase) {
        return false;
    }

    /**
     * TODO 参与团购
     * 用户参与团购,创建参团记录
     *
     * @param user          参团用户
     * @param groupPurchase 团购活动
     * @return 操作结果
     */
    @Override
    public boolean joinGroup(User user, GroupPurchase groupPurchase) {
        return false;
    }

    /**
     * TODO 退出团购
     * 用户退出某一团购活动,将参团表中对应用户和团购活动的记录设置为无效
     *
     * @param user          用户
     * @param groupPurchase 团购活动
     * @return 操作结果
     */
    @Override
    public boolean exitGroup(User user, GroupPurchase groupPurchase) {
        return false;
    }

    /**
     * TODO 获取所有参团用户
     * 查询参团表
     *
     * @param groupPurchase 团购活动
     * @return 参团用户表
     */
    @Override
    public List<User> listGroupUsers(GroupPurchase groupPurchase) {
        return null;
    }

    /**
     * TODO 取消团购活动
     * 将团购活动状态设置为已取消,将所有相关参团记录设置为无效
     * 退回所有已经支付用户的订单金额:获取商品id然后通过OrderService的订单退款方法完成业务
     * 团购活动过期未达到总参与人数时也将取消团购
     *
     * @param groupPurchase 要取消的团购活动
     * @return
     */
    @Override
    public boolean cancelGroup(GroupPurchase groupPurchase) {
        return false;
    }

    /**
     * TODO 通过商品关键词搜索团购
     * 先通过关键词搜索商品,再在团购活动表中搜索含有对应商品id的团购活动
     *
     * @param keywords 关键词
     * @param page     页码
     * @param pageSize 每页大小
     * @return 团购活动列表
     */
    @Override
    public List<GroupPurchase> searchByGoods(String keywords, int page, int pageSize) {
        return null;
    }

    /**
     * TODO 通过商品类型获取团购
     * 先通过类型搜索商已上架商品,再在团购活动表中搜索含有对应商品id的团购活动
     *
     * @param saletype 商品类型
     * @param page     页码
     * @param pageSize 每页大小
     * @return 团购活动列表
     */
    @Override
    public List<GroupPurchase> searchByType(Saletype saletype, int page, int pageSize) {
        return null;
    }

    /**
     * TODO 获取全部团购活动
     *
     * @param page     页码
     * @param pageSize 每页大小
     * @return 团购活动列表
     */
    @Override
    public List<GroupPurchase> listAllGroup(int page, int pageSize) {
        return null;
    }

    /**
     * TODO 获取参团人数前top名的团购活动
     * 用户首页展示和用户推荐
     *
     * @param top 排名
     * @return 团购活动列表
     */
    @Override
    public List<GroupPurchase> topGroup(int top) {
        return null;
    }
}
