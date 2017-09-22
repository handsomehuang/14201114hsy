package com.nchu.dao.impl;

import com.nchu.dao.UserDao;
import com.nchu.entity.User;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 2017年9月20日08:10:27
 * 用户DAO层实现类
 */
@Repository
public class UserDaoImpl implements UserDao {
    /**
     * 登录校验,传入use对象(只有账号和密码数据),
     * 查找比对用户账户密码信息,
     * 返回登录成功的用户对象
     *
     * @param user 待验证的用户对象
     * @return 登录成功的用户对象
     */
    @Override
    public User LoginCheck(User user) {
        return null;
    }

    /**
     * 保存一个对象到数据库
     *
     * @param model 要保存的对象
     * @return 主键
     */
    @Override
    public Integer save(User model) {
        return null;
    }

    /**
     * 保存或者更新,当数据库中 存在同id对象时执行更新操作,没有则执行插入操作
     *
     * @param model 实体类
     */
    @Override
    public void saveOrUpdate(User model) {

    }

    /**
     * 更新一条记录
     *
     * @param model 要更新的实例对象
     */
    @Override
    public void update(User model) {

    }

    /**
     * 混合方法
     *
     * @param model
     */
    @Override
    public void merge(User model) {

    }

    /**
     * 根据主键id删除记录
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {

    }

    /**
     * 删除所有指定的持久化对象
     *
     * @param users 要删除的列表
     */
    @Override
    public void deleteAll(List<User> users) {

    }

    /**
     * 通过实体对象删除记录
     *
     * @param model 实体对象
     */
    @Override
    public void deleteObject(User model) {

    }

    /**
     * 通过主键Id获取对象
     *
     * @param id 主键id
     * @return 实体对象
     */
    @Override
    public User get(Integer id) {
        return null;
    }

    /**
     * 统计整张表的记录数
     *
     * @return 返回记录条数
     */
    @Override
    public int countAll() {
        return 0;
    }

    /**
     * 查询全部数据记录
     *
     * @return 全部记录列表
     */
    @Override
    public List<User> listAll() {
        return null;
    }

    /**
     * 分页查询
     *
     * @param conditions 条件参数集合
     * @param page       页码
     * @param pageSize   每页大小
     * @return 查询结果集
     */
    @Override
    public List<User> searchPage(Map<String, Object> conditions, int page, int pageSize) {
        return null;
    }

    /**
     * 带排序的分页查询
     *
     * @param conditions 条件参数集合
     * @param orderBy    排序参考列
     * @param order      排序方式
     * @param page       页码
     * @param pageSize   每页大小
     * @return 查询结果集
     */
    @Override
    public List<User> searchPageByOrder(Map<String, Object> conditions, String orderBy, String order, int page, int pageSize) {
        return null;
    }
    @Override
    public List<User> searchListDefined(String HQL) {
        return null;
    }

    /**
     * 通过Id判断对象是否存在
     *
     * @param id 要判断的Id
     * @return 返回判断结果
     */
    @Override
    public boolean exists(Integer id) {
        return false;
    }
}
