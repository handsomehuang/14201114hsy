package com.nchu.enumdef;

/**
 * 2017年9月20日14:57:06
 * 用户角色枚举常量
 */
public enum UserRoleType {
    /*普通会员*/
    CUSTOMER(1),
    /*商家*/
    MERCHANT(2),
    /*管理员*/
    ADMIN(3);

    private int index;

    UserRoleType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
