package com.itheima.demo2map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        calc();
    }

    private static void calc() {
        List<String> locations=new ArrayList<>();
        String[] location={"北京","上海","广州","深圳"};
        Random random=new Random();
        for (int i = 0; i < 80; i++) {
            int index=random.nextInt(location.length);
            locations.add(location[index]);
        }
        System.out.println(locations);
        Map<String,Integer> map=new HashMap<>();
        for (String loc : locations) {
            if(map.containsKey(loc)){
                Integer count = map.get(loc);
                map.put(loc,count+1);
            }else{
                map.put(loc,1);
            }
        }
        System.out.println(map);
    }
}
