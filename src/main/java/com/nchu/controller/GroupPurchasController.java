package com.nchu.controller;

import com.nchu.entity.GroupPurchase;
import com.nchu.entity.dataView.SimpleGroupView;
import com.nchu.service.GroupPurchaseService;
import com.nchu.service.UserSessionService;
import com.nchu.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * 团购活动页面控制器
 *
 * @author 42586
 */
@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupPurchasController {
    @Autowired
    GroupPurchaseService groupPurchaseService;
    @Autowired
    UserSessionService sessionService;

    /*获取首页轮播图的热门活动*/
    @RequestMapping("/indexHotGroup")
    public List<SimpleGroupView> getIndexHotGroup() {
        return SimpleGroupView.getHotGroupList(groupPurchaseService.topGroup(4));
    }

    /*获取首页团购活动列表*/
    @RequestMapping("/indexGroupList")
    public List<SimpleGroupView> getIndexGroupList(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        return SimpleGroupView.getHotGroupList(groupPurchaseService.listAllGroup(page, pageSize));
    }

    /*获取总页数*/
    @RequestMapping(value = "/groupListPageAccount", method = RequestMethod.GET)
    public Long getPageAccount(@RequestParam("pageSize") int pageSize) {
        return groupPurchaseService.groupPageAccount(pageSize);
    }

    @RequestMapping(value = "/getGroupInfo")
    public GroupPurchase getGroupInfo(@RequestParam("groupId") Long groupId_web, HttpServletRequest httpRequest) {
        Long groupId;
        if (groupId_web != null) {
            groupId = groupId_web;
        } else {
            groupId = (Long) sessionService.getAttr(httpRequest, "groupId");
        }
        return groupPurchaseService.getById(groupId);
    }

    /*获取服务器时间*/
    @RequestMapping("/serverTime")
    public Timestamp getServerTime() {
        return DateUtil.getCurrentTimestamp();
    }
}
