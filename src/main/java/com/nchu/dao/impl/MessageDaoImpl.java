package com.nchu.dao.impl;

import com.nchu.dao.MessageDao;
import com.nchu.entity.Message;
import com.nchu.entity.User;
import com.nchu.enumdef.MessageType;
import com.nchu.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 2017年9月20日09:04:37 消息DAO实现类
 */
@Repository
@Transactional
public class MessageDaoImpl implements MessageDao {
    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获取指定用户的指定类型的消息
     *
     * @param messageType 消息类型,由枚举常量定义
     * @param isRead      消息是否已读,对应数据库isread字段进行条件查询
     * @param user        要查询消息的用户
     * @return 返回消息列表, 无记录请返回null
     */
    @Override
    public List<Message> getUserMsg(MessageType messageType, boolean isRead, User user) {
        String hql;
        Query query;
        if (messageType == MessageType.ALL) {
            hql = "from Message where receiver.id =:user and isread=:isread";
            query = getSession().createQuery(hql);
        } else {
            hql = "from Message where receiver.id =:user and type =:msgType and isread=:isread";
            query = getSession().createQuery(hql);
            query.setParameter("msgType", messageType.getIndex());
        }
        query.setParameter("user", user.getId());
        query.setParameter("isread", isRead);
        return query.list();
    }

    /**
     * 将指定用户的指定类型的消息全部设置为已读
     *
     * @param messageType 消息类型
     * @param user        用户对象
     */
    @Override
    public void readAll(MessageType messageType, User user) {

        String sql = "update Message msg set msg.isread = true WHERE type=:messageType and receiver.id=:receiveid";
        Query query = getSession().createQuery(sql);
        query.setParameter("messageType", messageType.getIndex());
        query.setParameter("receiveid", user.getId());
        query.executeUpdate();

    }

    /**
     * 删除用户指定类型的全部消息
     *
     * @param receiver    用户
     * @param messageType 要清空的消息类型
     * @return 操作结果
     */
    @Override
    public boolean deleteAllMessage(User receiver, MessageType messageType) {
        String hql;
        Query query;
        if (messageType == MessageType.ALL) {
            hql = "delete from Message where Message.receiver.id=:receiver";
            query = getSession().createQuery(hql);
        } else {
            hql = "delete from Message  where Message.receiver.id=:receiver and type =: msgType";
            query = getSession().createQuery(hql);
            query.setParameter("msgType", messageType.getIndex());
        }
        query.setParameter("receiver", receiver.getId());
        query.executeUpdate();
        return true;
    }

    /**
     * 保存一个对象到数据库
     *
     * @param model 要保存的对象
     * @return 主键
     */
    @Override
    public Long save(Message model) {
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
    public void saveOrUpdate(Message model) {
        model.setGmtModified(DateUtil.getCurrentTimestamp());
        getSession().saveOrUpdate(model);
    }

    /**
     * 更新一条记录
     *
     * @param model 要更新的实例对象
     */
    @Override
    public void update(Message model) {
        model.setGmtModified(DateUtil.getCurrentTimestamp());
        getSession().update(model);
    }

    /**
     * 混合方法
     *
     * @param model
     */
    @Override
    public void merge(Message model) {
        getSession().merge(model);
    }

    /**
     * 根据主键id删除记录
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        Message message = (Message) getSession().load(Message.class, id);
        getSession().delete(message);
    }

    /**
     * 删除所有指定的持久化对象
     *
     * @param messages 要删除的列表
     */
    @Override
    public void deleteAll(List<Message> messages) {
        for (Message ms : messages) {
            getSession().delete(ms);
        }
    }

    /**
     * 通过实体对象删除记录
     *
     * @param model 实体对象
     */
    @Override
    public void deleteObject(Message model) {
        getSession().delete(model);
    }

    /**
     * 通过主键Id获取对象
     *
     * @param id 主键id
     * @return 实体对象
     */
    @Override
    public Message get(Long id) {
        return (Message) getSession().get(Message.class, id);
    }

    /**
     * 统计整张表的记录数
     *
     * @return 返回记录条数
     */
    @Override
    public Long countAll() {
        String hql = "select count(*) from Message ";
        Long count = (Long) getSession().createQuery(hql).uniqueResult();
        return count;
    }

    /**
     * 查询全部数据记录
     *
     * @return 全部记录列表
     */
    @Override
    public List<Message> listAll() {
        String hql = "from Message ";
        Query query = getSession().createQuery(hql);
        List<Message> list = query.list();
        return list;
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
    public List<Message> searchPage(Map<String, Object> conditions, int page, int pageSize) {
        Session session = getSession();
        String hql;
        if (conditions == null) {
            hql = "from Message";
        } else {
            Iterator<String> iterator = conditions.keySet().iterator();
            StringBuilder stringBuilder = new StringBuilder("from Message af where ");
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
        List<Message> list = query.list();
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
    public List<Message> searchPageByOrder(Map<String, Object> conditions, String orderBy, String order, int page,
                                           int pageSize) {
        Session session = getSession();
        String hql;
        if (conditions == null) {
            hql = "from Message order by " + orderBy + " " + order;
            System.out.println("test.....");
        } else {
            Iterator<String> iterator = conditions.keySet().iterator();
            StringBuilder stringBuilder = new StringBuilder("from Message af where ");
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
        List<Message> list = query.list();
        return list;
    }

    /**
     * 直接通过HQL语句进行查询
     *
     * @param HQL 语句字符串
     * @return 查询结果列表
     */
    @Override
    public List<Message> searchListDefined(String HQL) {
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
        Message message = (Message) getSession().get(Message.class, id);
        return message != null ? true : false;
    }
}
