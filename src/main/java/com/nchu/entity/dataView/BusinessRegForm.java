package com.nchu.entity.dataView;

import com.nchu.entity.Saletype;
import com.nchu.entity.Shop;
import com.nchu.entity.User;
import com.nchu.enumdef.UserRoleType;

/**
 * 商家注册页面表单类
 */
public class BusinessRegForm {
    String account;
    String password;
    String passwordCheck;
    String tel;
    String mail;
    String shopName;
    String realName;
    String idCard;
    long saleType;
    String licensePic;
    String licenseCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public long getSaleType() {
        return saleType;
    }

    public void setSaleType(long saleType) {
        this.saleType = saleType;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public User getUser() {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setEmail(mail);
        user.setRole(UserRoleType.MERCHANT.toString());
        user.setRelname(realName);
        user.setIdCard(idCard);
        user.setTelephone(tel);
        return user;
    }

    public Shop getShop() {
        Shop shop = new Shop();
        Saletype saletype = new Saletype();
        saletype.setId(saleType);
        shop.setName(shopName);
        shop.setSaletype(saletype);
        shop.setLicensePic(licensePic);
        shop.setLicenseCode(licenseCode);
        shop.setServiceTel(tel);
        return shop;
    }
}
