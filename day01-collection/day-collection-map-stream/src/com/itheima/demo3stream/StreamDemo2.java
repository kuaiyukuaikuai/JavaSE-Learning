package com.itheima.demo3stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //1.获取集合的Stream流:调用集合提供的stream()方法
        Collection<String> list = new ArrayList<>();
        Stream<String> s1=list.stream();

        //2.Map集合获取Stream流
        Map<String,Integer> map = new HashMap<>();
        //获取key的Stream流
        Stream<String> s2 = map.keySet().stream();
        // 获取value的Stream流
        Stream<Integer> s3 = map.values().stream();
        // 获取entry的Stream流
        Stream<Map.Entry<String, Integer>> s4 = map.entrySet().stream();

        //3.数组获取Stream流
        String[] name = {"张1","张2","张3"};
        Stream<String> s5 = Arrays.stream(name);

        Stream<String> s6 = Stream.of(name);
        Stream<Integer> s7 = Stream.of(1,2,3,4,5);
    }
}
