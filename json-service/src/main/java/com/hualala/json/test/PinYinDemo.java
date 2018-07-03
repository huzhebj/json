package com.hualala.json.test;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.hualala.json.util.PinYinUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PinYinDemo {
    @Test
    public void toPinYin() throws PinyinException {
        String pinYin = PinYinUtils.toPinYin("河南省");
        System.out.println(pinYin);//hns;he;nan;sheng;henansheng
    }

}
