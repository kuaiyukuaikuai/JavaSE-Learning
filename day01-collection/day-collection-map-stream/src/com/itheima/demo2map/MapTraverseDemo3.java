package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo3 {
    public static void main(String[] args) {
        //目标:Map集合的遍历方式
        //方法一:键找值
        Map<String, String> map = new HashMap<>();
        map.put("小张", "18");
        map.put("小王", "19");
        map.put("小张", "20");
        map.put("小李", "21");
        System.out.println(map);
        //1.获取所有的键到Set集合中
        Set<String> keys = map.keySet();
        //2.遍历Set集合,获取每一个键
        for (String key : keys) {
            //3.根据键获取值
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

        //方法二:键值对找键值对  Entry对象
        Set<Map.Entry<String, String>> entries = map.entrySet();//获取所有的键值对
        for (Map.Entry<String, String> entry : entries) {
            //获取键
            String key = entry.getKey();
            //获取值
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        //方法三:Lambda表达式
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
