package com.nchu.service.impl;

import com.nchu.dao.MessageDao;
import com.nchu.entity.Message;
import com.nchu.entity.User;
import com.nchu.enumdef.MessageType;
import com.nchu.exception.MessageException;
import com.nchu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017-9-23 18:11:38
 * 消息相关业务接口实现类
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    /**
     * TODO 阅读消息
     * 将消息状态修改为已读
     *
     * @param message 消息
     * @return 操作结果
     */
    @Override
    public boolean readMessage(Message message) {
        message.setIsread(true);
        try {
            messageDao.update(message);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * TODO 已读全部消息
     * 将用户指定类型的全部消息设置为已读状态
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @return 操作结果
     */
    @Override
    public boolean readAllMessage(MessageType messageType, User receiver) throws MessageException {
        try {
            messageDao.readAll(messageType, receiver);
        } catch (Exception e) {
            throw new MessageException("操作失败,请重试");
        }
        return true;
    }

    /**
     * TODO 发送消息
     *
     * @param message 要发送的消息
     * @return 操作结果
     */
    @Override
    public boolean sendMessage(Message message) throws MessageException {
        if (message.getContent().length() == 0) {
            throw new MessageException("消息不能为空");
        }
        try {
            messageDao.save(message);
        } catch (Exception e) {
            throw new MessageException("系统异常,发送失败");
        }
        return true;
    }

    /**
     * TODO 删除消息
     *
     * @param message 要删除的消息
     * @return 操作结果
     */
    @Override
    public boolean deleteMessage(Message message) throws MessageException {
        try {
            messageDao.deleteObject(message);
        } catch (Exception e) {
            throw new MessageException("操作失败,请重试");
        }
        return true;
    }

    /**
     * TODO 删除用户指定类型的全部消息
     *
     * @param receiver    用户
     * @param messageType 要清空的消息类型
     * @return 操作结果
     */
    @Override
    public boolean deleteAllMessage(User receiver, MessageType messageType) throws MessageException {
        try {
            messageDao.deleteAllMessage(receiver, messageType);
        } catch (Exception e) {
            throw new MessageException("清空失败,请重试");
        }
        return true;
    }

    /**
     * TODO 获取所有未读消息
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @param page        页码
     * @param pageSize    每页大小
     * @return 消息列表
     */
    @Override
    public List<Message> listAllUnRead(User receiver, MessageType messageType, int page, int pageSize) throws MessageException {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("receiveid", receiver.getId());
        conditions.put("isread", false);
        /*如果是获取全部类型的消息则不需要类型条件*/
        if (messageType != MessageType.ALL) {
            conditions.put("type", messageType.getIndex());
        }
        List<Message> messageList;
        try {
            messageList = messageDao.searchPage(conditions, page, pageSize);
        } catch (Exception e) {
            throw new MessageException("消息加载失败");
        }
        if (messageType == null) {
            throw new MessageException("暂无消息");
        }
        return messageList;
    }

    /**
     * TODO 获取所有已读消息
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @param page        页码
     * @param pageSize    每页大小
     * @return 消息列表
     */
    @Override
    public List<Message> listAllReaded(User receiver, MessageType messageType, int page, int pageSize) throws MessageException {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("receiveid", receiver.getId());
        conditions.put("isread", true);
        /*如果是获取全部类型的消息则不需要类型条件*/
        if (messageType != MessageType.ALL) {
            conditions.put("type", messageType.getIndex());
        }
        List<Message> messageList;
        try {
            messageList = messageDao.searchPage(conditions, page, pageSize);
        } catch (Exception e) {
            throw new MessageException("消息加载失败");
        }
        if (messageType == null) {
            throw new MessageException("暂无消息");
        }
        return messageList;
    }
}
