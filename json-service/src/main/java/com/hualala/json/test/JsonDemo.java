package com.hualala.json.test;

import com.alibaba.fastjson.JSONObject;
import com.hualala.json.bean.PrewarningReceiver;
import com.hualala.json.bean.User;
import com.hualala.json.util.DataUtil;
import com.hualala.json.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JsonDemo {

    @Test
    public void jsonToBean() throws Exception {
        String jsonStr = "[{\"accountID\":\"137452\",\"groupID\":\"119\",\"itemID\":\"137452\",\"itemName\":\"胡哲\",\"loginName\":\"gogo-huzhe\",\"shopID\":\"76022913\",\"shopName\":\"1万万饭庄(房山分店)aaa\",\"userEmail\":\"huzhe@hualala.com\",\"userMobile\":\"18001214950\",\"userName\":\"胡哲\",\"weixin\":\"已开启\",\"weixinMessageAllowed\":\"1\",\"wxMsgMpID\":\"0A2A-6A0Uf502bc\",\"wxMsgOpenID\":\"oaKph0kBHDutwvy-ApACWYrhUXok\"},{\"accountID\":\"137452\",\"groupID\":\"119\",\"itemID\":\"137452\",\"itemName\":\"胡哲\",\"loginName\":\"gogo-huzhe\",\"shopID\":\"76056926\",\"shopName\":\"组织创建门店\",\"userEmail\":\"huzhe@hualala.com\",\"userMobile\":\"18001214950\",\"userName\":\"胡哲\",\"weixin\":\"已开启\",\"weixinMessageAllowed\":\"1\",\"wxMsgMpID\":\"0A2A-6A0Uf502bc\",\"wxMsgOpenID\":\"oaKph0kBHDutwvy-ApACWYrhUXok\"}]";
        List<PrewarningReceiver> prewarningReceiverList = DataUtil.parseJsonToBeanList(jsonStr, PrewarningReceiver.class);
        System.out.println(prewarningReceiverList);
    }

    @Test
    public void beanToJson() throws Exception {
        List<PrewarningReceiver> prewarningReceiverList = new ArrayList<>();
        PrewarningReceiver prewarningReceiver1 = new PrewarningReceiver();
        prewarningReceiver1.setAccountID("137452");
        prewarningReceiver1.setUserName("胡哲");
        prewarningReceiver1.setShopID("76022913");
        prewarningReceiver1.setShopName("1万万饭庄(房山分店)aaa");
        prewarningReceiver1.setUserEmail("huzhe@hualala.com");
        prewarningReceiver1.setUserMobile("18001214950");
        prewarningReceiver1.setWeixinMessageAllowed("1");
        prewarningReceiver1.setWxMsgOpenID("oaKph0kBHDutwvy-ApACWYrhUXok");
        prewarningReceiver1.setGroupID("119");
        prewarningReceiver1.setLoginName("gogo-huzhe");
        prewarningReceiver1.setItemID("137452");
        prewarningReceiver1.setItemName("胡哲");
        prewarningReceiver1.setWeixin("已开启");
        prewarningReceiver1.setWxMsgMpID("0A2A-6A0Uf502bc");
        prewarningReceiverList.add(prewarningReceiver1);
        PrewarningReceiver prewarningReceiver2 = new PrewarningReceiver();
        prewarningReceiver2.setAccountID("137452");
        prewarningReceiver2.setUserName("胡哲");
        prewarningReceiver2.setShopID("76056926");
        prewarningReceiver2.setShopName("组织创建门店");
        prewarningReceiver2.setUserEmail("huzhe@hualala.com");
        prewarningReceiver2.setUserMobile("18001214950");
        prewarningReceiver2.setWeixinMessageAllowed("1");
        prewarningReceiver2.setWxMsgOpenID("oaKph0kBHDutwvy-ApACWYrhUXok");
        prewarningReceiver2.setGroupID("119");
        prewarningReceiver2.setLoginName("gogo-huzhe");
        prewarningReceiver2.setItemID("137452");
        prewarningReceiver2.setItemName("胡哲");
        prewarningReceiver2.setWeixin("已开启");
        prewarningReceiver2.setWxMsgMpID("0A2A-6A0Uf502bc");
        prewarningReceiverList.add(prewarningReceiver2);

        String jsonStr = JSONObject.toJSONString(prewarningReceiverList);
        System.out.println(jsonStr);
    }

    @Test
    public void jsonToBean2() throws Exception {
        String jsonStr = "[{\"name\":\"张三\",\"age\":10,\"cardID\":412822198908101179,\"addr\":\"河南.驻马店\"},{\"name\":\"李四\",\"age\":12,\"cardID\":412822198908101171,\"addr\":\"河南.南阳\"}]";
        List<User> userList = DataUtil.parseJsonToBeanList(jsonStr, User.class);
        System.out.println(userList);
    }

    @Test
    public void beanToJson2() throws Exception {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(10);
        user1.setCardID(412822198908101179L);
        user1.setAddr("河南.驻马店");
        userList.add(user1);
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(12);
        user2.setCardID(412822198908101171L);
        user2.setAddr("河南.南阳");
        userList.add(user2);

        String jsonStr = JSONObject.toJSONString(userList);
        System.out.println(jsonStr);
    }

    @Test
    public void jsonToBean3() throws Exception {
        String jsonStr = "[{\"name\":\"张三\",\"age\":10,\"cardID\":412822198908101179,\"addr\":\"河南.驻马店\"},{\"name\":\"李四\",\"age\":12,\"cardID\":412822198908101171,\"addr\":\"河南.南阳\"}]";
        List<User> userList = (List<User>) Utils.transformJsonToBeanList(jsonStr, User.class);
        System.out.println(userList);
    }

    @Test
    public void jsonToBean4() throws Exception {
        String jsonStr = "[{\"accountID\":\"137452\",\"groupID\":\"119\",\"itemID\":\"137452\",\"itemName\":\"胡哲\",\"loginName\":\"gogo-huzhe\",\"shopID\":\"76022913\",\"shopName\":\"1万万饭庄(房山分店)aaa\",\"userEmail\":\"huzhe@hualala.com\",\"userMobile\":\"18001214950\",\"userName\":\"胡哲\",\"weixin\":\"已开启\",\"weixinMessageAllowed\":\"1\",\"wxMsgMpID\":\"0A2A-6A0Uf502bc\",\"wxMsgOpenID\":\"oaKph0kBHDutwvy-ApACWYrhUXok\"},{\"accountID\":\"137452\",\"groupID\":\"119\",\"itemID\":\"137452\",\"itemName\":\"胡哲\",\"loginName\":\"gogo-huzhe\",\"shopID\":\"76056926\",\"shopName\":\"组织创建门店\",\"userEmail\":\"huzhe@hualala.com\",\"userMobile\":\"18001214950\",\"userName\":\"胡哲\",\"weixin\":\"已开启\",\"weixinMessageAllowed\":\"1\",\"wxMsgMpID\":\"0A2A-6A0Uf502bc\",\"wxMsgOpenID\":\"oaKph0kBHDutwvy-ApACWYrhUXok\"}]";
        List<PrewarningReceiver> receiverList = (List<PrewarningReceiver>) Utils.transformJsonToBeanList(jsonStr, PrewarningReceiver.class);
        System.out.println(receiverList);
    }

    @Test
    public void jsonToBean5() throws Exception {
        String jsonStr = "{\"accountID\":\"137452\",\"groupID\":\"119\",\"itemID\":\"137452\",\"itemName\":\"胡哲\",\"loginName\":\"gogo-huzhe\",\"shopID\":\"76056926\",\"shopName\":\"组织创建门店\",\"userEmail\":\"huzhe@hualala.com\",\"userMobile\":\"18001214950\",\"userName\":\"胡哲\",\"weixin\":\"已开启\",\"weixinMessageAllowed\":\"1\",\"wxMsgMpID\":\"0A2A-6A0Uf502bc\",\"wxMsgOpenID\":\"oaKph0kBHDutwvy-ApACWYrhUXok\"}";
        PrewarningReceiver prewarningReceiver = (PrewarningReceiver) Utils.transformJsonToBean(jsonStr, PrewarningReceiver.class);
        System.out.println(prewarningReceiver);
    }
}
