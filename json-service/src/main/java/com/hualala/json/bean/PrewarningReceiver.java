package com.hualala.json.bean;

public class PrewarningReceiver {
    String accountID;//账号ID
    String userName;//账号姓名
    String shopID;//店铺ID
    String shopName;//店铺名称
    String userEmail;//邮箱
    String userMobile;//手机
    String weixinMessageAllowed;//微信消息推送 0:不推送;1:推送
    String wxMsgOpenID;//微信消息推送openID
    String groupID;//集团ID
    String loginName;//子帐号登录名
    String itemID;//与accountID对应，前端需要
    String itemName;//与userName对应，前端需要
    String weixin;//与userName对应，前端需要
    String wxMsgMpID;//微信消息推送mpID

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getWeixinMessageAllowed() {
        return weixinMessageAllowed;
    }

    public void setWeixinMessageAllowed(String weixinMessageAllowed) {
        this.weixinMessageAllowed = weixinMessageAllowed;
    }

    public String getWxMsgOpenID() {
        return wxMsgOpenID;
    }

    public void setWxMsgOpenID(String wxMsgOpenID) {
        this.wxMsgOpenID = wxMsgOpenID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWxMsgMpID() {
        return wxMsgMpID;
    }

    public void setWxMsgMpID(String wxMsgMpID) {
        this.wxMsgMpID = wxMsgMpID;
    }
}
