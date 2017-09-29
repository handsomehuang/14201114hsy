package com.nchu.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单实体类
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "orders")
public class Order implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    /*下订单的用户*/
    private User user;
    /*订单关联的商品*/
    private Goods goods;
    /*订单关联的快递方式*/
    private ExpressDelivery expressDelivery;
    /*订单金额*/
    private BigDecimal price;
    /*支付方式*/
    private String payMethod;
    /*订单状态*/
    private String orderStatus;
    private String remark;
    /*订单关联的售后记录表*/
    private Set<AfterSale> afterSales = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "expressid")
    public ExpressDelivery getExpressDelivery() {
        return expressDelivery;
    }

    public void setExpressDelivery(ExpressDelivery expressDelivery) {
        this.expressDelivery = expressDelivery;
    }

    @ManyToOne
    @JoinColumn(name = "goodsid")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "order")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<AfterSale> getAfterSales() {
        return afterSales;
    }

    public void setAfterSales(Set<AfterSale> afterSales) {
        this.afterSales = afterSales;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "price", precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "pay_method")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Basic
    @Column(name = "status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "remark", length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (gmtCreate != null ? !gmtCreate.equals(order.gmtCreate) : order.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(order.gmtModified) : order.gmtModified != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (goods != null ? !goods.equals(order.goods) : order.goods != null) return false;
        if (expressDelivery != null ? !expressDelivery.equals(order.expressDelivery) : order.expressDelivery != null)
            return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (remark != null ? !remark.equals(order.remark) : order.remark != null) return false;
        return afterSales != null ? afterSales.equals(order.afterSales) : order.afterSales == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        result = 31 * result + (expressDelivery != null ? expressDelivery.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (afterSales != null ? afterSales.hashCode() : 0);
        return result;
    }
}
