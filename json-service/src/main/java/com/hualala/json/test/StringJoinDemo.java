package com.hualala.json.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StringJoinDemo {
    @Test
    public void join() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String join1 = String.join(",", list);
        String join2 = String.join("#", list);
        System.out.println(join1);//1,2,3,4
        System.out.println(join2);//1#2#3#4
    }

}
