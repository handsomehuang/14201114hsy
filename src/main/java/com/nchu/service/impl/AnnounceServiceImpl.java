package com.nchu.service.impl;

import com.nchu.entity.Announcement;
import com.nchu.entity.User;
import com.nchu.service.AnnounceService;

import java.util.List;

/**
 * 2017-9-24 15:28:16
 * 系统公告相关业务接口实现类
 */
public class AnnounceServiceImpl implements AnnounceService {
    /**
     * TODO 发布公告
     * 验证操作人身份为管理员
     *
     * @param announcement 公告实体
     * @param operator     操作
     * @return 操作结果
     */
    @Override
    public boolean addAnnounceMent(Announcement announcement, User operator) {
        return false;
    }

    /**
     * TODO 获取全部公告
     *
     * @param page     页码
     * @param pageSize 每页大小
     * @return 公告列表
     */
    @Override
    public List<Announcement> listAll(int page, int pageSize) {
        return null;
    }

    /**
     * TODO 删除公告
     * 验证操作人为管理员
     *
     * @param announcement 要删除的公告
     * @param operator     操作人
     * @return 操作结果
     */
    @Override
    public boolean deleteAnnouncement(Announcement announcement, User operator) {
        return false;
    }
}
