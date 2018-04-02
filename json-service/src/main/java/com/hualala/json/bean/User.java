package com.hualala.json.bean;

import lombok.Data;

@Data//利用此注解可以省去手动创建setter和getter方法的麻烦
public class User {
    String name;
    int age;
    long cardID;
    String addr;
}
