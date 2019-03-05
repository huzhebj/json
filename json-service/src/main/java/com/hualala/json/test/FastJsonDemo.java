package com.hualala.json.test;

import com.alibaba.fastjson.JSONObject;
import com.hualala.json.bean.HouseDetail;
import com.hualala.json.bean.People;
import com.hualala.json.bean.User;
import org.apache.commons.lang3.StringUtils;
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
    public void getObject(){
        //json（{"1":{},"2":{}}）-->Bean
        String jsonString = "{\"user\":{\"addr\":\"河南.驻马店\",\"age\":10,\"cardID\":412822198908101179,\"name\":\"小明\"},\"people\":{\"age\":10,\"name\":\"小明\"}}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString, JSONObject.class);
        User user = jsonObject.getObject("user", User.class);
        System.out.println(user);
        //User(name=小明, age=10, cardID=412822198908101179, addr=河南.驻马店)
        People people = jsonObject.getObject("people", People.class);
        System.out.println(people);
        //People(name=小明, age=10)
    }

    @Test
    public void getString(){
        //json（{"1":"","2":""}）-->String
        String jsonString = "{\"user1\":\"小明\",\"user2\":\"小军\"}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString, JSONObject.class);
        String user1 = jsonObject.getString("user1");
        System.out.println(user1);//小明
        String user2 = jsonObject.getString("user2");
        System.out.println(user2);//小军
    }

    @Test
    public void put(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user1","小明");
        jsonObject.put("user2","小军");
        String user1 = jsonObject.getString("user1");
        System.out.println(user1);//小明
        String user2 = jsonObject.getString("user2");
        System.out.println(user2);//小军
    }

    @Test
    public void remove(){
        //json（{"1":{},"2":{}}）-->Bean
        String jsonString = "{\"user\":{\"addr\":\"河南.驻马店\",\"age\":10,\"cardID\":412822198908101179,\"name\":\"小明\"},\"people\":{\"age\":10,\"name\":\"小明\"}}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString, JSONObject.class);
        Object user = jsonObject.remove("user");
        System.out.println(user);
        //{"cardID":412822198908101179,"name":"小明","addr":"河南.驻马店","age":10}
        System.out.println(jsonObject.toString());
        //{"people":{"name":"小明","age":10}}
    }

    @Test
    public void parseArray(){
        //json（[{}]）-->List<Bean>
        String jsonString = "[{\"addr\":\"河南.驻马店\",\"age\":10,\"cardID\":412822198908101179,\"name\":\"小明\"},{\"addr\":\"河南.南阳\",\"age\":11,\"cardID\":412822198908101120,\"name\":\"小军\"}]";
        List<User> list = JSONObject.parseArray(jsonString, User.class);
        System.out.println(list);
        //[User(name=小明, age=10, cardID=412822198908101179, addr=河南.驻马店), User(name=小军, age=11, cardID=412822198908101120, addr=河南.南阳)]
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
    public void demo(){
        int dateWay = 2; //1:按周 2：按月
        int dateNo = 3; //日期号
        String date = "";
        if(dateWay == 1){
            switch (dateNo){
                case 1:
                    date = "周一";
                    break;
                case 2:
                    date = "周二";
                    break;
                case 3:
                    date = "周三";
                    break;
                case 4:
                    date = "周四";
                    break;
            }
        }else if(dateWay == 2){
            switch (dateNo){
                case 1:
                    date = "1号";
                    break;
                case 2:
                    date = "2号";
                    break;
                case 3:
                    date = "3号";
                    break;
                case 4:
                    date = "4号";
                    break;
            }
        }

        System.out.println(date);

    }

    @Test
    public void demo2(){
        /*JSONObject object = new JSONObject();

        JSONObject data = new JSONObject();
        data.put("houseID",1589);
        data.put("houseName","仓库名称");

        object.put("data",data);
        String jsonString = object.toJSONString();
        System.out.println(jsonString);*/

        JSONObject object = new JSONObject();

        /*JSONObject data = new JSONObject();
        data.put("houseID",1589);
        data.put("houseName","仓库名称");*/

        HouseDetail houseDetail = new HouseDetail();
        houseDetail.setHouseID(1589L);
        houseDetail.setHouseName("仓库名称");

        object.put("data",houseDetail);
        String jsonString = object.toJSONString();
        System.out.println(jsonString);

    }

}
