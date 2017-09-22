package com.nchu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 2017年9月20日08:10:06
 * 基础DAO接口
 *
 * @param <Entity> 要操作的实体对象
 * @param <PK>     表的主键
 */
public interface BaseDao<Entity extends Serializable, PK extends Serializable> {

    /**
     * 保存一个对象到数据库
     *
     * @param model 要保存的对象
     * @return 主键
     */
    PK save(Entity model);

    /**
     * 保存或者更新,当数据库中 存在同id对象时执行更新操作,没有则执行插入操作
     *
     * @param model 实体类
     */
    void saveOrUpdate(Entity model);

    /**
     * 更新一条记录
     *
     * @param model 要更新的实例对象
     */
    void update(Entity model);

    /**
     * 混合方法
     *
     * @param model
     */
    void merge(Entity model);

    /**
     * 根据主键id删除记录
     *
     * @param id
     */
    void delete(PK id);

    /**
     * 删除所有指定的持久化对象
     *
     * @param entityList 要删除的列表
     */
    void deleteAll(List<Entity> entityList);

    /**
     * 通过实体对象删除记录
     *
     * @param model 实体对象
     */
    void deleteObject(Entity model);

    /**
     * 通过主键Id获取对象
     *
     * @param id 主键id
     * @return 实体对象
     */
    Entity get(PK id);

    /**
     * 统计整张表的记录数
     *
     * @return 返回记录条数
     */
    int countAll();

    /**
     * 查询全部数据记录
     *
     * @return 全部记录列表
     */
    List<Entity> listAll();

    /**
     * 分页查询
     *
     * @param conditions 条件参数集合
     * @param page       页码
     * @param pageSize   每页大小
     * @return 查询结果集
     */
    List<Entity> searchPage(Map<String, Object> conditions, int page, int pageSize);

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
    List<Entity> searchPageByOrder(Map<String, Object> conditions, String orderBy, String order, int page, int pageSize);

    /**
     * 直接通过HQL语句进行查询
     *
     * @param HQL 语句字符串
     * @return 查询结果列表
     */

    List<Entity> searchListDefined(String HQL);

    /**
     * 通过Id判断对象是否存在
     *
     * @param id 要判断的Id
     * @return 返回判断结果
     */
    boolean exists(PK id);

}
