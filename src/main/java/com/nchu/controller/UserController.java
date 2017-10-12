package com.nchu.controller;

import com.nchu.entity.Shop;
import com.nchu.entity.User;
import com.nchu.entity.dataView.BusinessRegForm;
import com.nchu.exception.ServiceException;
import com.nchu.exception.ShopException;
import com.nchu.exception.UserServiceException;
import com.nchu.exception.UserSessionException;
import com.nchu.service.ShopService;
import com.nchu.service.UserService;
import com.nchu.service.UserSessionService;
import com.nchu.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 * 2017-9-25 15:30:47
 * 用户账户相关控制器
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserSessionService sessionService;
    @Autowired
    ShopService shopService;
    /*
     * 用户登录验证
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody User user, HttpServletRequest request) throws ServiceException {
        /*如果用户已经登录则直接通过*/
        try {
            User loginUser = sessionService.getUser(request);
            /*验证已经登录的用户信息*/
            if (user.getAccount().equals(loginUser.getAccount()) && MD5Util.validate(user.getPassword(), loginUser.getPassword())) {
                return true;
            } else {
                throw new UserServiceException("用户名或密码不正确");
            }
        } catch (UserSessionException e) {
            /*出现异常说明用户未登录,则通过数据库进行验证*/
            user = userService.login(user);
            sessionService.addUser(user, request);
            return true;
        }
    }

    /*用户注销*/
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request) {
        sessionService.removeUser(request);
    }

    /*会员注册*/
    @RequestMapping(value = "/vipReg", method = RequestMethod.POST)
    public Boolean register(@RequestBody User user) throws UserServiceException, MessagingException {
        /*System.out.println(user.getPassword() + ":" + user.getAccount());*/
        userService.register(user);
        return true;
    }

    /*商家注册*/
    @RequestMapping(value = "/businessReg", method = RequestMethod.POST)
    public Boolean businessReg(@RequestBody BusinessRegForm form) throws UserServiceException, MessagingException, ShopException {
        /*获取用户注册信息*/
        User user = form.getUser();
        userService.register(user);
        /*获取店铺注册信息*/
        Shop shop = form.getShop();
        shop.setUser(user);
        shopService.createShop(shop);
        System.out.println(form.getAccount());
        return true;
    }

    /*获取用户个人信息*/
    @RequestMapping(value = "/info/{account}", method = RequestMethod.GET)
    public User getUserInfoByAccount(@PathVariable("account") String account) throws ServiceException {
        User user = userService.getUserByAccount(account);
        return user;
    }

    /*获取当前在线用户的个人信息*/
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public User getLoginUserInfo(HttpServletRequest request) throws ServiceException {
        User user = sessionService.getUser(request);
        return user;
    }

}
