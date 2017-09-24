package com.nchu.service;

import com.nchu.entity.Announcement;
import com.nchu.entity.User;

import java.util.List;

/**
 * 2017-9-24 15:28:16
 * 系统公告相关业务接口
 */
public interface AnnounceService {
    /**
     * TODO 发布公告
     * 验证操作人身份为管理员
     *
     * @param announcement 公告实体
     * @param operator     操作
     * @return 操作结果
     */
    boolean addAnnounceMent(Announcement announcement, User operator);

    /**
     * TODO 获取全部公告
     *
     * @param page     页码
     * @param pageSize 每页大小
     * @return 公告列表
     */
    List<Announcement> listAll(int page, int pageSize);

    /**
     * TODO 删除公告
     * 验证操作人为管理员
     *
     * @param announcement 要删除的公告
     * @param operator     操作人
     * @return 操作结果
     */
    boolean deleteAnnouncement(Announcement announcement, User operator);


}
