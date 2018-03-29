package com.hualala.json.test;

import com.hualala.json.bean.PrewarningReceiver;
import com.hualala.json.util.DataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
