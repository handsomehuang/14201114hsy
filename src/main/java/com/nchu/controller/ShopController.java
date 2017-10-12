package com.nchu.controller;

import com.nchu.entity.Saletype;
import com.nchu.entity.Shop;
import com.nchu.entity.dataView.ShopDateView;
import com.nchu.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    /*获取销售类型表*/
    @RequestMapping(value = "/saleTypeList", method = RequestMethod.GET)
    public List<Saletype> getSaleType() {
        return shopService.getAllSaleType();
    }

    /*获取推荐商家*/
    @RequestMapping(value = "getHotShop", method = RequestMethod.GET)
    public List<ShopDateView> getHotShop(@RequestParam("number") int number) {
        return ShopDateView.transFromList(shopService.listAll().subList(0, number));
    }
}
