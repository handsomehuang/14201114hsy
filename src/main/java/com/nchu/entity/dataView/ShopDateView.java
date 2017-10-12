package com.nchu.entity.dataView;

import com.nchu.entity.Shop;

import java.util.List;
import java.util.stream.Collectors;

/*店铺实体页面数据视图*/
public class ShopDateView {
    private long id;
    /*店铺所有者*/
    private Long owerId;
    private String owerName;
    private String gmtCreate;
    private String name;
    private String addresss;
    private String serviceTel;
    /*销售类型*/
    private String saleTypeName;
    /*是否认证*/
    private byte isVerify;
    private String licenseCode;
    private String licensePic;
    private String logo;
    private String description;
    private boolean islocked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getOwerId() {
        return owerId;
    }

    public void setOwerId(Long owerId) {
        this.owerId = owerId;
    }

    public String getOwerName() {
        return owerName;
    }

    public void setOwerName(String owerName) {
        this.owerName = owerName;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public String getSaleTypeName() {
        return saleTypeName;
    }

    public void setSaleTypeName(String saleTypeName) {
        this.saleTypeName = saleTypeName;
    }

    public byte getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(byte isVerify) {
        this.isVerify = isVerify;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIslocked() {
        return islocked;
    }

    public void setIslocked(boolean islocked) {
        this.islocked = islocked;
    }

    /*从店铺实体类转化为店铺数据视图*/
    public static ShopDateView transFrom(Shop shop) {
        ShopDateView shopDateView = new ShopDateView();
        shopDateView.setId(shop.getId());
        shopDateView.setAddresss(shop.getAddresss());
        shopDateView.setDescription(shop.getDescription());
        shopDateView.setGmtCreate(shop.getGmtCreate().toString().substring(0, 16));
        shopDateView.setIslocked(shop.isIslocked());
        shopDateView.setIsVerify(shop.getIsVerify());
        shopDateView.setLicenseCode(shop.getLicenseCode());
        shopDateView.setLicensePic(shop.getLicensePic());
        shopDateView.setLogo(shop.getLogo());
        shopDateView.setName(shop.getName());
        shopDateView.setServiceTel(shop.getServiceTel());
        shopDateView.setOwerName(shop.getUser().getNickName());
        shopDateView.setOwerId(shop.getUser().getId());
        shopDateView.setSaleTypeName(shop.getSaletype().getName());
        return shopDateView;
    }

    public static List<ShopDateView> transFromList(List<Shop> shopList) {
        return shopList.stream().map(shop -> {
            return ShopDateView.transFrom(shop);
        }).collect(Collectors.toList());
    }
}
