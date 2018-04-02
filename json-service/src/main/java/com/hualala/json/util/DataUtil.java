package com.hualala.json.util;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by zhaoxiaodong on 2016/12/1.
 */
public class DataUtil {

    private static Logger logger = LoggerFactory.getLogger(DataUtil.class);

    public static Map<String, Object> beanToMap(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        //如果bean  是map
        if (bean instanceof Map) {
            map = (Map<String, Object>)bean;
        } else {
            try {
                Map<String, String> tmap = BeanUtils.describe(bean);
                map.putAll(tmap);
                map.remove("class");
            } catch (Exception e) {
                logger.error("bean To Map system error ", e);
                logger.error("bean [" + bean + "]");
            }
        }
        return map;
    }
    public static Map<String, Object> beanToMap(Object bean, boolean includeNull) {
        Map<String, Object> map = new HashMap<String, Object>();
        //如果bean  是map
        if (bean instanceof Map) {
            map = (Map<String, Object>)bean;
        } else {
            try {
                Map<String, String> tmpMap = BeanUtils.describe(bean);
                tmpMap.remove("class");
                if (includeNull) {
                    map.putAll(tmpMap);
                } else {
                    Iterator<String> ite = tmpMap.keySet().iterator();
                    while (ite.hasNext()) {
                        String key = ite.next();
                        if (tmpMap.get(key) != null) {
                            map.put(key, tmpMap.get(key));
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("bean To Map system error ", e);
                logger.error("bean [" + bean + "]");
            }
        }
        return map;
    }

    public static void mapToBean(Map<String, Object> dest, Object orig) {
        Iterator<String> iterator = dest.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            try {
                BeanUtils.setProperty(orig, key, dest.get(key));
            } catch (Exception e) {
                logger.error("system error map to bean" , e);
                logger.error("dest [" + dest + "]");
                continue;
            }
        }
    }

    public static <T> T mapToBean(Map<String, Object> dest, Class<T> className) {
        try {
            T t = className.newInstance();
            mapToBean(dest, t);
            return t;
        } catch (Exception e) {
            logger.error("system error " , e);
            logger.error("dest [" + dest + "]");
        }
        return null;
    }

    public static <T> List<T> mapToBean(List<Map<String, Object>> dests, Class<T> className) {

        if(dests == null)
            return null;

        List<T> list = new ArrayList<T>();

        for(Map<String,Object> dest : dests)
            list.add(mapToBean(dest,className));

        return list;
    }

    public static <T> boolean matching(List<T> o1, List<T> o2){
        if (o1 == null && o2 == null) return true;
        if (o1.size() == 0 && o2.size() == 0) return true;
        if (o1.size() != o2.size()) return false;
        for(T o : o1)
            if(!o2.contains(o))
                return false;
        return true;
    }

    public static <T> List<T> diff(List<T> o1, List<T> o2){
        if (o1 == null || o1.size()== 0 || o2 == null|| o2.size() == 0) return o1;
        List<T> list = new ArrayList<>();
        for(T o : o1)
            if(!o2.contains(o))
                list.add(o);
        return list;
    }

    //此方法非最优
    public static  <T> List<T> parseJsonToBeanList(String jsonStr, Class<T> clazz) throws Exception {
        List<T> list = null; //包含的实体列表
        list = new ArrayList<T>();
        JSONArray jArray = new JSONArray(jsonStr);
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject jso = (JSONObject) jArray.opt(i);
            Field[] fs = clazz.getDeclaredFields();
            T t = clazz.newInstance();
            for (Field field : fs) {
                String fieldName = field.getName();
                Method m = clazz.getDeclaredMethod("set"+ upperCase(fieldName),field.getType());
                Object arg = jso.opt(fieldName);
                if (m != null && m.getName() != null && arg != null) {
                    if (!arg.toString().equals("null") && !arg.toString().equals("")) {
                        if (field.getType().getName().equals("int")) {
                            m.invoke(t, Integer.valueOf(arg.toString()));
                        } else if (field.getType().getName().equals("long")) {
                            m.invoke(t, Long.valueOf(arg.toString()));
                        } else if (field.getType().getName().equals("short")) {
                            m.invoke(t, Short.valueOf(arg.toString()));
                        } else {
                            m.invoke(t, arg);
                        }
                    }
                }
            }
            list.add(t);
        }
        return list;
    }

    public static String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static <T> List<T> mapListToBeanList(List<Map<String, Object>> mapList, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        if (mapList == null || mapList.size() == 0)
            return list;
        for (Map<String, Object> m : mapList) {
            list.add(mapToBean(m, tClass));
        }
        return list;
    }

    public static <T> List<Map<String, Object>> beanListToMapList(List<T> dataList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (dataList == null || dataList.size() == 0)
            return mapList;
        for (T o : dataList) {
            mapList.add(beanToMap(o));
        }
        return mapList;
    }

    public static String getPercent(int x,int y){
        String result = "";//接受百分比的值　　
        double xDouble = x*1.0;
        double yDouble = y*1.0;
        double tempresult = xDouble/yDouble;
        DecimalFormat df = new DecimalFormat("0%");
        result= df.format(tempresult);
        return result;
    }

}
