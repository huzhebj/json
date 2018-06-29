package com.hualala.json.bean;

import lombok.Data;

@Data//利用此注解可以省去手动创建setter、getter、toString、equals和hashCode方法的麻烦
public class Student {
    String id;
    User user;
}
