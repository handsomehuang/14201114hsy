package com.nchu.dao;

import com.nchu.entity.User;

/**
 * 2017年9月19日16:02:57
 *
 * @author xjw
 * 用户DAO接口,继承基础DAO接口并进行扩展
 */
public interface UserDao extends BaseDao<User, Long> {

    /**
     * 登录校验,传入use对象(只有账号和密码数据),
     * 查找比对用户账户密码信息,
     * 返回登录成功的用户对象
     *
     * @param user 待验证的用户对象
     * @return 登录成功的用户对象
     */
    User LoginCheck(User user);

}
