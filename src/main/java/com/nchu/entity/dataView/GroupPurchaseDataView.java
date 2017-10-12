package com.nchu.entity.dataView;

import com.nchu.entity.Goods;
import com.nchu.entity.GoodsPicture;
import com.nchu.entity.GroupPurchase;

import java.sql.Timestamp;

/**
 * 2017-10-8 19:55:074
 * 团购活动数据视图,用于向前端返回数据和映射前端表单
 */
public class GroupPurchaseDataView {
    GroupPurchase groupPurchase;
    Goods goods;
    GoodsPicture goodsPicture;
}
