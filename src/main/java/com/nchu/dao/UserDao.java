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
    User loginCheck(User user);

    /**
     * 判断用户账号是否已经存在,用户注册前进行账号重复性检查
     *
     * @param account 要检查的账号
     * @return 若账号已存在返回true, 否则返回false
     */
    boolean accountCheck(String account);

    /**
     * 通过账号获取用户信息
     *
     * @param account 用户账户
     * @return 返回用户实体
     */
    User getUserByAccount(String account);
}
