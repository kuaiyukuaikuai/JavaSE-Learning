package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        //目标:认识Map集合
        //特点:无序,不重复,无索引,键值对可以为null
        // 1.创建Map集合
        Map<String, String> map = new HashMap<>();
        // 2.添加元素
        map.put("张三", "23");
        map.put("小王", "18");
        map.put("小张", "19");
        map.put("小陈", "20");
        map.put("小张", "21");
        System.out.println(map);
    }
}
