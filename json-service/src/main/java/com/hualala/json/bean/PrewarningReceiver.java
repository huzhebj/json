package com.hualala.json.bean;

import lombok.Data;

@Data//利用此注解可以省去手动创建setter和getter方法的麻烦
public class PrewarningReceiver {
    String accountID;
    String userName;
    String shopID;
    String shopName;
    String userEmail;
    String userMobile;
    String weixinMessageAllowed;
    String wxMsgOpenID;
    String groupID;
    String loginName;
    String itemID;
    String itemName;
    String weixin;
    String wxMsgMpID;
}
