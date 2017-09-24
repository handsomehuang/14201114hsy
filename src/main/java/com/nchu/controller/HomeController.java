package com.nchu.controller;

import com.nchu.dao.OrderDao;
import com.nchu.dao.UserDao;
import com.nchu.dao.VouchersDao;
import com.nchu.entity.*;
import com.nchu.enumdef.UserRoleType;
import com.nchu.util.DateUtil;
import com.nchu.util.MD5Util;
import com.nchu.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Iterator;

@Controller
public class HomeController {
    @Autowired
    UserDao userDao;
    @Autowired
    VouchersDao vouchersDao;
    @Autowired
    OrderDao orderDao;

    @RequestMapping("/")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("home")
    public String home() {
        return "index";
    }

    @RequestMapping("business")
    public String business() {
        return "business/business";
    }

    private void lazyLoadTest() {
        User user = userDao.get(Long.valueOf(1));
        System.out.println(user.getNickName());
        Iterator<ReceivingAddress> iterator = user.getReceivingAddress().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getAddress());
        }
    }

    private void saveuserTest() {
        User user = new User();
        user.setAccount("ADMIN");
        user.setPassword(MD5Util.encode2hex("1320074071"));
        //user.setRelname("ADMIN");
        //user.setNickName("ADMIN");
        user.setEmail("ADMIN@qq.com");
        user.setTelephone("12334564");
        user.setGmtCreate(DateUtil.getCurrentTimestamp());
        user.setGmtModified(DateUtil.getCurrentTimestamp());
        user.setCheckcode(MD5Util.encode2hex(UUIDUtils.getUUID() + DateUtil.getCurrentTime()));
        user.setBalance(BigDecimal.valueOf(12.3));
        user.setRole(UserRoleType.CUSTOMER.name());
        userDao.save(user);
    }

    private void testdao() {
        Vouchers vouchers = new Vouchers();
        vouchers.setGmtCreate(DateUtil.getCurrentTimestamp());
        vouchers.setGmtModified(DateUtil.getCurrentTimestamp());
        User temp = new User();
        temp.setId(1L);
        vouchers.setUser(temp);
        vouchers.setIndate(DateUtil.getCurrentTimestamp());
        vouchers.setPrice(BigDecimal.valueOf(12.3));
        vouchers.setLimituse(BigDecimal.valueOf(130));
        vouchers.setSeriacod(MD5Util.encode2hex(UUIDUtils.getUUID()));
        vouchers.setStatus("1");
        vouchers.setIsused(false);
        vouchersDao.save(vouchers);
    }

    void testOrderDao() {
        Order o = new Order();
        User u = new User();
        u.setId(1L);
        o.setUser(u);
        Goods g = new Goods();
        g.setId(1L);
        o.setGoods(g);
        ExpressDelivery ed = new ExpressDelivery();
        ed.setId(1L);
        o.setExpressDelivery(ed);
        OrderStatus os = new OrderStatus();
        os.setId(1L);
        o.setOrderStatus(os);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        o.setGmtCreate(d);
        o.setGmtModified(d);

        o.setPrice(BigDecimal.valueOf(10));
        o.setOrderStatus(os);
        o.setRemark("5");
        orderDao.save(o);

    }
}
