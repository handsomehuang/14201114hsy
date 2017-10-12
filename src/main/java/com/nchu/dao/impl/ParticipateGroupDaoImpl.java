package com.nchu.dao.impl;

import com.nchu.dao.ParticipateGroupDao;
import com.nchu.entity.AfterSale;
import com.nchu.entity.GroupPurchase;
import com.nchu.entity.ParticipateGroup;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nchu.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2017-9-25 16:24:04
 * 用户参团表DAO接口实现
 */
@Repository
@Transactional
public class ParticipateGroupDaoImpl implements ParticipateGroupDao {

    @Autowired
    SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存一个对象到数据库
     *
     * @param model 要保存的对象
     * @return 主键
     */
    @Override
    public Long save(ParticipateGroup model) {
        model.setGmtCreate(DateUtil.getCurrentTimestamp());
        model.setGmtModified(DateUtil.getCurrentTimestamp());
        getSession().save(model);
        return model.getId();
    }

    /**
     * 保存或者更新,当数据库中 存在同id对象时执行更新操作,没有则执行插入操作
     *
     * @param model 实体类
     */
    @Override
    public void saveOrUpdate(ParticipateGroup model) {
        model.setGmtModified(DateUtil.getCurrentTimestamp());
        getSession().saveOrUpdate(model);
    }

    /**
     * 更新一条记录
     *
     * @param model 要更新的实例对象
     */
    @Override
    public void update(ParticipateGroup model) {
        model.setGmtModified(DateUtil.getCurrentTimestamp());
        getSession().update(model);
    }

    /**
     * 混合方法
     *
     * @param model
     */
    @Override
    public void merge(ParticipateGroup model) {
        getSession().merge(model);
    }

    /**
     * 根据主键id删除记录
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        ParticipateGroup model = (ParticipateGroup) getSession().get(ParticipateGroup.class, id);
        getSession().delete(model);
    }

    /**
     * 删除所有指定的持久化对象
     *
     * @param participateGroups 要删除的列表
     */
    @Override
    public void deleteAll(List<ParticipateGroup> participateGroups) {
        for (int i = 0; i < participateGroups.size(); i++) {
            getSession().delete(participateGroups.get(i));
        }
    }

    /**
     * 通过实体对象删除记录
     *
     * @param model 实体对象
     */
    @Override
    public void deleteObject(ParticipateGroup model) {
        getSession().delete(model);
    }

    /**
     * 通过主键Id获取对象
     *
     * @param id 主键id
     * @return 实体对象
     */
    @Override
    public ParticipateGroup get(Long id) {
        return (ParticipateGroup) getSession().get(ParticipateGroup.class, id);
    }

    /**
     * 统计整张表的记录数
     *
     * @return 返回记录条数
     */
    @Override
    public Long countAll() {
        String sql = "select count(*) from ParticipateGroup ";
        Long count = (Long) getSession().createQuery(sql).uniqueResult();
        return count;
    }

    /**
     * 查询全部数据记录
     *
     * @return 全部记录列表
     */
    @Override
    public List<ParticipateGroup> listAll() {
        String hql = "from ParticipateGroup ";
        Query query = getSession().createQuery(hql);
        return query.list();
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
    public List<ParticipateGroup> searchPage(Map<String, Object> conditions, int page, int pageSize) {
        Session session = getSession();
        String hql;
        if (conditions == null) {
            hql = "from ParticipateGroup ";
        } else {
            Iterator<String> iterator = conditions.keySet().iterator();
            StringBuilder stringBuilder = new StringBuilder("from ParticipateGroup pg where ");
            while (iterator.hasNext()) {
                String key = iterator.next();
                stringBuilder.append(key + " =  " + conditions.get(key));
                if (iterator.hasNext()) {
                    stringBuilder.append(" AND ");
                }
            }
            hql = stringBuilder.toString();
        }

        Query query = session.createQuery(hql);
        int startIndex = (page - 1) * pageSize;
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        List<ParticipateGroup> list = query.list();
        return list;
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
    public List<ParticipateGroup> searchPageByOrder(Map<String, Object> conditions, String orderBy, String order, int page, int pageSize) {
        Session session = getSession();
        String hql;
        if (conditions == null) {
            hql = "from ParticipateGroup order by " + orderBy + " " + order;
            System.out.println("test.....");
        } else {
            Iterator<String> iterator = conditions.keySet().iterator();
            StringBuilder stringBuilder = new StringBuilder("from ParticipateGroup af where ");
            while (iterator.hasNext()) {
                String key = iterator.next();
                stringBuilder.append(key + " =  " + conditions.get(key));
                if (iterator.hasNext()) {
                    stringBuilder.append(" AND ");
                }
            }
            hql = stringBuilder.toString();
        }

        Query query = session.createQuery(hql);
        int startIndex = (page - 1) * pageSize;
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        List<ParticipateGroup> list = query.list();
        return list;
    }

    /**
     * 直接通过HQL语句进行查询
     *
     * @param HQL 语句字符串
     * @return 查询结果列表
     */
    @Override
    public List<ParticipateGroup> searchListDefined(String HQL) {
        Query query = getSession().createQuery(HQL);
        return query.list();
    }

    /**
     * 通过Id判断对象是否存在
     *
     * @param id 要判断的Id
     * @return 返回判断结果
     */
    @Override
    public boolean exists(Long id) {
        ParticipateGroup model = (ParticipateGroup) getSession().get(ParticipateGroup.class, id);
        if (model != null)
            return true;
        else
            return false;
    }

    /**
     * 通过用户id和团购活动id增加参团记录
     *
     * @param userid  用户id
     * @param groupid 活动id
     */
    @Override
    public void createParticipateGroup(Long userid, Long groupid) {
        String hql = "insert into participate_group (gmt_create,gmt_modified,userid,groupid,iseffective) values(now(),now(),?,?,?)";
        Query query = getSession().createQuery(hql);
        query.setBigInteger(0, BigInteger.valueOf(userid));
        query.setBigInteger(1, BigInteger.valueOf(groupid));
        query.setByte(2, (byte) 1);
        query.executeUpdate();
    }

    /**
     * 通过用户id和团购活动id，修改参团记录为无效
     *
     * @param userid  用户id
     * @param groupid 活动id
     */
    @Override
    public void removeParticipateGroup(Long userid, Long groupid) {
        String hql = "update ParticipateGroup pg set pg.iseffective=0 where userid=? AND groupid=?";
        Query query = getSession().createQuery(hql);
        query.setBigInteger(0, BigInteger.valueOf(userid));
        query.setBigInteger(1, BigInteger.valueOf(groupid));
        query.executeUpdate();
    }

    @Override
    public List<ParticipateGroup> getAllByGroupPurchase(GroupPurchase model) {
        String hql = "from ParticipateGroup where groupid=?";
        Query query = getSession().createQuery(hql);
        query.setBigInteger(0, BigInteger.valueOf(model.getId()));
        return query.list();
    }

}
