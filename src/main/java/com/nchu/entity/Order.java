package com.nchu.entity;

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
public class Order implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private User user;
    /*订单关联的商品*/
    private Goods goods;
    /*订单关联的快递方式*/
    private ExpressDelivery expressDelivery;
    /*订单金额*/
    private BigDecimal price;
    /*订单状态*/
    private OrderStatus orderStatus;
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
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified", nullable = false)
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "status")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 255)
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
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (remark != null ? !remark.equals(order.remark) : order.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
