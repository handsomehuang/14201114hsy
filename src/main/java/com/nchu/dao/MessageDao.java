package com.nchu.dao;

import com.nchu.entity.Message;
import com.nchu.entity.User;
import com.nchu.enumdef.MessageType;

import java.util.List;

/**
 * 2017年9月20日08:35:29
 * 消息表DAO接口
 */
public interface MessageDao extends BaseDao<Message, Long> {
    /**
     * 获取指定用户的指定类型的消息
     *
     * @param messageType 消息类型,由枚举常量定义
     * @param user        要查询消息的用户
     * @param isRead      消息是否已读,对应数据库isread字段进行条件查询
     * @return 返回消息列表, 无记录请返回null
     */
    List<Message> getUserMsg(MessageType messageType, boolean isRead, User user);

    /**
     * 将指定用户的指定类型的消息全部设置为已读
     *
     * @param messageType 消息类型
     * @param user        用户对象
     */
    void readAll(MessageType messageType, User user);

    /**
     * 删除用户指定类型的全部消息
     *
     * @param receiver    用户
     * @param messageType 要清空的消息类型
     * @return 操作结果
     */
    boolean deleteAllMessage(User receiver, MessageType messageType);
}
