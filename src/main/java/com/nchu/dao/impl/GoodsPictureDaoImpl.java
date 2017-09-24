package com.nchu.dao.impl;

import com.nchu.dao.GoodsPictureDao;
import com.nchu.entity.GoodsPicture;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GoodsPictureDaoImpl implements GoodsPictureDao {
    @Autowired
    SessionFactory sessionFactory;
    /**
     * 获取Hibernate 的session
     *
     * @return
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存一个对象到数据库
     *
     * @param model 要保存的对象
     * @return 主键
     */
    @Override
    public Long save(GoodsPicture model) {
        return null;
    }

    /**
     * 保存或者更新,当数据库中 存在同id对象时执行更新操作,没有则执行插入操作
     *
     * @param model 实体类
     */
    @Override
    public void saveOrUpdate(GoodsPicture model) {

    }

    /**
     * 更新一条记录
     *
     * @param model 要更新的实例对象
     */
    @Override
    public void update(GoodsPicture model) {

    }

    /**
     * 混合方法
     *
     * @param model
     */
    @Override
    public void merge(GoodsPicture model) {

    }

    /**
     * 根据主键id删除记录
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

    }

    /**
     * 删除所有指定的持久化对象
     *
     * @param goodsPictures 要删除的列表
     */
    @Override
    public void deleteAll(List<GoodsPicture> goodsPictures) {

    }

    /**
     * 通过实体对象删除记录
     *
     * @param model 实体对象
     */
    @Override
    public void deleteObject(GoodsPicture model) {

    }

    /**
     * 通过主键Id获取对象
     *
     * @param id 主键id
     * @return 实体对象
     */
    @Override
    public GoodsPicture get(Long id) {
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
    public List<GoodsPicture> listAll() {
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
    public List<GoodsPicture> searchPage(Map<String, Object> conditions, int page, int pageSize) {
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
    public List<GoodsPicture> searchPageByOrder(Map<String, Object> conditions, String orderBy, String order, int page, int pageSize) {
        return null;
    }

    /**
     * 直接通过HQL语句进行查询
     *
     * @param HQL 语句字符串
     * @return 查询结果列表
     */
    @Override
    public List<GoodsPicture> searchListDefined(String HQL) {
        return null;
    }

    /**
     * 通过Id判断对象是否存在
     *
     * @param id 要判断的Id
     * @return 返回判断结果
     */
    @Override
    public boolean exists(Long id) {
        return false;
    }
}
