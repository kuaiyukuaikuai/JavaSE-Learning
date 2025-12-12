package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("小张", 18);
        map.put("小王", 19);
        map.put("小李", 20);
        map.put("小张", 20);
        System.out.println(map);

        //写代码演示常用功能
        System.out.println(map.get("小张"));//根据键获取值
        System.out.println(map.containsKey("小张"));//判断集合中是否包含指定的键
        System.out.println(map.containsValue(20));//判断集合中是否包含指定的值
        System.out.println(map.size());//获取集合的长度
        System.out.println(map.isEmpty());//判断集合是否为空
        System.out.println(map.remove("小张"));//删除键值对
        map.clear();//清空集合
        System.out.println(map);//输出集合
    }
}
