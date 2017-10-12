package com.nchu.service;

import com.nchu.entity.Message;
import com.nchu.entity.User;
import com.nchu.enumdef.MessageType;
import com.nchu.exception.MessageException;

import java.util.List;

/**
 * 2017-9-23 18:11:38
 * 消息相关业务接口
 */
public interface MessageService {
    /**
     * TODO 阅读消息
     * 将消息状态修改为已读
     *
     * @param message 消息
     * @return 操作结果
     */
    boolean readMessage(Message message);

    /**
     * TODO 已读全部消息
     * 将用户指定类型的全部消息设置为已读状态
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @return 操作结果
     */
    boolean readAllMessage(MessageType messageType, User receiver) throws MessageException;

    /**
     * TODO 发送消息
     *
     * @param message 要发送的消息
     * @return 操作结果
     */
    boolean sendMessage(Message message) throws MessageException;

    /**
     * TODO 删除消息
     *
     * @param message 要删除的消息
     * @return 操作结果
     */
    boolean deleteMessage(Message message) throws MessageException;

    /**
     * TODO 删除用户指定类型的全部消息
     *
     * @param receiver    用户
     * @param messageType 要清空的消息类型
     * @return 操作结果
     */
    boolean deleteAllMessage(User receiver, MessageType messageType) throws MessageException;

    /**
     * TODO 获取所有未读消息
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @param page        页码
     * @param pageSize    每页大小
     * @return 消息列表
     */
    List<Message> listAllUnRead(User receiver, MessageType messageType, int page, int pageSize) throws MessageException;

    /**
     * TODO 获取所有已读消息
     *
     * @param receiver    接收人
     * @param messageType 消息类型
     * @param page        页码
     * @param pageSize    每页大小
     * @return 消息列表
     */
    List<Message> listAllReaded(User receiver, MessageType messageType, int page, int pageSize) throws MessageException;
}
