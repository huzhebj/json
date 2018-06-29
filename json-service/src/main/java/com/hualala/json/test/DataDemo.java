package com.hualala.json.test;

import com.hualala.json.bean.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataDemo {

    @Test
    public void demo1() {
        People people = new People();
        people.setAge(10);
        people.setName("小明");
        System.out.print(people.toString());
        /**
         * 不重写toString方法people.toString()的结果：com.hualala.json.bean.People@1603cd68
         * 不重写toString方法people.toString()的结果：People{name='小明', age=10}
         * 使用@Data注解后people.toString()的结果：People(name=小明, age=10)，说明@Data注解帮助我们重写了toString方法，但返回格式不同
         */
    }

    @Test
    public void demo2() {
        Set<People> set = new HashSet<>();
        People people1 = new People();
        people1.setAge(10);
        people1.setName("小明");
        set.add(people1);
        People people2 = new People();
        people2.setAge(10);
        people2.setName("小明");
        set.add(people2);
        System.out.print(set);

        /**
         * 不重写equals和hashCode方法set含有两个元素
         *  重写equals和hashCode方法set含有1个元素
         *  使用@Data注解时set含有1个元素，说明@Data注解帮助我们重写了equals和hashCode方法
         */
    }
}
