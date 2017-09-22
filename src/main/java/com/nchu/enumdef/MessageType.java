package com.nchu.enumdef;

/**
 * 2017年9月20日08:55:08
 * 消息类型枚举常量,定义消息类型
 */
public enum MessageType {
    /**
     * @SYSTEM 系统消息
     * @CUNSTOMER 用户信息
     * @ALL 全部消息
     */
    SYSTEM(0), CUSTOMER(1), ALL(2);
    private int index;

    MessageType(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }
}
