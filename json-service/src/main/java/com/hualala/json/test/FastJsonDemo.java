package com.hualala.json.test;

import com.alibaba.fastjson.JSONObject;
import com.hualala.json.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FastJsonDemo {
    @Test
    public void parseObject(){
        //json（{}）-->Bean
        String jsonString = "{\"addr\":\"河南.驻马店\",\"age\":10,\"cardID\":412822198908101179,\"name\":\"小明\"}";
        User user = JSONObject.parseObject(jsonString, User.class);
        System.out.println(user);//User(name=小明, age=10, cardID=412822198908101179, addr=河南.驻马店)
    }

    @Test
    public void toJSONString1(){
        //json（{}）<--Bean
        User user = new User();
        user.setName("小明");
        user.setAge(10);
        user.setAddr("河南.驻马店");
        user.setCardID(412822198908101179L);
        String jsonString = JSONObject.toJSONString(user);
        System.out.println(jsonString);//{"addr":"河南.驻马店","age":10,"cardID":412822198908101179,"name":"小明"}
    }

    @Test
    public void toJSONString2(){
        //json（[{}]）<--List<Bean>
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("小明");
        user1.setAge(10);
        user1.setAddr("河南.驻马店");
        user1.setCardID(412822198908101179L);
        list.add(user1);
        User user2 = new User();
        user2.setName("小军");
        user2.setAge(11);
        user2.setAddr("河南.南阳");
        user2.setCardID(412822198908101120L);
        list.add(user2);

        String jsonString = JSONObject.toJSONString(list);
        System.out.println(jsonString);
        //[{"addr":"河南.驻马店","age":10,"cardID":412822198908101179,"name":"小明"},{"addr":"河南.南阳","age":11,"cardID":412822198908101120,"name":"小军"}]
    }

    @Test
    public void parseArray(){
        //json（[{}]）-->List<Bean>
        String jsonString = "[{\"addr\":\"河南.驻马店\",\"age\":10,\"cardID\":412822198908101179,\"name\":\"小明\"},{\"addr\":\"河南.南阳\",\"age\":11,\"cardID\":412822198908101120,\"name\":\"小军\"}]";
        List<User> list = JSONObject.parseArray(jsonString, User.class);
        System.out.println(list);
        //[User(name=小明, age=10, cardID=412822198908101179, addr=河南.驻马店), User(name=小军, age=11, cardID=412822198908101120, addr=河南.南阳)]
    }
}
