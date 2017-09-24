package com.nchu.service.impl;

import com.nchu.entity.Message;
import com.nchu.entity.User;
import com.nchu.enumdef.MessageType;
import com.nchu.service.MessageService;

import java.util.List;

/**
 * 2017-9-23 18:11:38
 * 消息相关业务接口实现类
 */
public class MessageServiceImpl implements MessageService {
    /**
     * TODO 阅读消息
     * 将消息状态修改为已读
     *
     * @param message 消息
     * @return 操作结果
     */
    @Override
    public boolean readMessage(Message message) {
        return false;
    }

    /**
     * TODO 已读全部消息
     * 将用户指定类型的全部消息设置为已读状态
     *
     * @param receiver 接收人
     * @return 操作结果
     */
    @Override
    public boolean readAllMessage(User receiver) {
        return false;
    }

    /**
     * TODO 发送消息
     *
     * @param message 要发送的消息
     * @return 操作结果
     */
    @Override
    public boolean sendMessage(Message message) {
        return false;
    }

    /**
     * TODO 删除消息
     *
     * @param message 要删除的消息
     * @return 操作结果
     */
    @Override
    public boolean deleteMessage(Message message) {
        return false;
    }

    /**
     * TODO 删除用户指定类型的全部消息
     *
     * @param receiver    用户
     * @param messageType 要清空的消息类型
     * @return 操作结果
     */
    @Override
    public boolean deleteAllMessage(User receiver, MessageType messageType) {
        return false;
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
    public List<Message> listAllUnRead(User receiver, MessageType messageType, int page, int pageSize) {
        return null;
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
    public List<Message> listAllReaded(User receiver, MessageType messageType, int page, int pageSize) {
        return null;
    }
}
