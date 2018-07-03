package com.hualala.json.util;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

public class PinYinUtils {

    public static String toPinYin(String str) throws PinyinException {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PinyinHelper.getShortPinyin(str)).append(";");
        stringBuilder.append(PinyinHelper.convertToPinyinString(str, ";", PinyinFormat.WITHOUT_TONE)).append(";");
        stringBuilder.append(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE));
        return stringBuilder.toString();
    }
}
