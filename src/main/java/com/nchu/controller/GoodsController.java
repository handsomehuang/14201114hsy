package com.nchu.controller;

import com.nchu.entity.Goods;
import com.nchu.service.GoodsService;
import com.nchu.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品相关控制器
 *
 * @author 42586
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserSessionService sessionService;

    /*获取商品详*/
    @RequestMapping(value = "goodsInfo", method = RequestMethod.GET)
    public Goods getGoodsInfo(HttpServletRequest request) {
        Long goodId = (Long) sessionService.getAttr(request, "goodsId");
        return goodsService.getById(goodId);
    }
}
