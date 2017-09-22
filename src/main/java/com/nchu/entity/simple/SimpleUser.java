package com.nchu.entity.simple;

import java.math.BigInteger;
import java.sql.Date;

/**
 * 简单用户信息
 */

public class SimpleUser {
    private long id;
    private String account;
    private String relname;
    private String nickName;
    private String email;
    private String telephone;
    /*头像*/
    private String headportrait;
    private boolean sex;
    private Date birthday;
    /*角色id*/
    private long roleId;
    private Boolean islocked;
    /*积分*/
    private long integral;
    private BigInteger balance;

    public SimpleUser() {
    }

    public SimpleUser(long id, String account, String relname, String nickName, String email, String telephone, String headportrait, boolean sex, Date birthday, long roleId, Boolean islocked, long integral, BigInteger balance) {
        this.id = id;
        this.account = account;
        this.relname = relname;
        this.nickName = nickName;
        this.email = email;
        this.telephone = telephone;
        this.headportrait = headportrait;
        this.sex = sex;
        this.birthday = birthday;
        this.roleId = roleId;
        this.islocked = islocked;
        this.integral = integral;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public Boolean getIslocked() {
        return islocked;
    }

    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }
}
