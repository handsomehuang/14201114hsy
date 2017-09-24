package com.nchu.service.impl;

import com.nchu.entity.Goods;
import com.nchu.entity.Shop;
import com.nchu.entity.User;
import com.nchu.service.GoodsService;

import java.util.List;

/**
 * 2017-9-23 17:22:07
 * 商品相关业务接口实现类
 */
public class GoodsServiceImpl implements GoodsService {
    /**
     * TODO 添加商品
     * 1.判断操作人身份是否为商家
     * 2.获取并判断商家店铺状态是否封禁
     * 3.补充商品对象属性,并插入数据库,商品默认为下架状态
     *
     * @param goods    要添加的商品
     * @param operator 操作人
     * @return 操作结果
     */
    @Override
    public boolean addGoods(Goods goods, User operator) {
        return false;
    }

    /**
     * TODO 修改商品信息
     * 需要判断操作人身份再执行,禁止通过该方法修改商品上下架状态图
     *
     * @param goods    包含新商品信息的商品对象
     * @param operator 操作人
     * @return 操作结果
     */
    @Override
    public boolean updateGoodsInfo(Goods goods, User operator) {
        return false;
    }

    /**
     * TODO 关键字商品查询
     * 按关键词进行商品模糊查询,若关键词为空则查询全部,商品状态条件为已上架
     *
     * @param keywords 商品关键字
     * @param page     页码
     * @param pageSize 每页大小
     * @return 商品列表
     */
    @Override
    public List<Goods> searchGoods(String keywords, int page, int pageSize) {
        return null;
    }

    /**
     * TODO 删除商品
     * 要删除的商品必须是已下架的商品,否则删除失败
     *
     * @param goods    要删除的商品
     * @param operator 操作者
     * @return 操作结果
     */
    @Override
    public boolean deleteGoods(Goods goods, User operator) {
        return false;
    }

    /**
     * TODO 获取店铺中的所有上架/下架商品
     *
     * @param shop        要查询的商品
     * @param isonshelves 是否上架
     * @param page        页码
     * @param pageSize    每页大小
     * @return 返回商品列表
     */
    @Override
    public List<Goods> listGoods(Shop shop, boolean isonshelves, int page, int pageSize) {
        return null;
    }

    /**
     * TODO 下架商品
     * 下架指定店铺的商品,需要鉴定用户为店铺所有者,商品为该店铺商品
     * 商品下架的同时将取消商品的团购活动
     *
     * @param shop
     * @param goods
     * @param operator
     * @return
     */
    @Override
    public boolean shelveGoods(Shop shop, Goods goods, User operator) {
        return false;
    }

    /**
     * TODO 下架店铺中的全部商品
     * 此功能仅提供给管理员封禁店铺时同步将店铺商品自动下架,所以要检查操作员身份为管理员
     *
     * @param shop     要下架商品的店铺
     * @param operator 操作人
     * @return 操作结果
     */
    @Override
    public boolean shelveAll(Shop shop, User operator) {
        return false;
    }
}
