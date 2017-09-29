package com.nchu.dao;

import com.nchu.entity.User;
import com.nchu.entity.Vouchers;

/**
 * 2017年9月20日13:56:01
 * 优惠券Dao接口
 */
public interface VouchersDao extends BaseDao<Vouchers, Long> {
    /**
     * 删除指定用户全部无效的优惠券
     *
     * @param user
     */
    void deleteInvalid(User user);
}
