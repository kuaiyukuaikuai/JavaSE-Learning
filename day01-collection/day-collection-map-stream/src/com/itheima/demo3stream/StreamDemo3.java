package com.itheima.demo3stream;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张小四");
        list.add("张小三");
        list.stream().filter(name -> name.startsWith("张")).forEach(name -> System.out.println(name));

        //2.排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(99.9);
        scores.add(66.6);
        scores.add(77.7);
        scores.add(88.8);
        scores.add(55.5);
        scores.add(33.3);
        scores.add(44.4);
        //升序
        scores.stream().sorted().forEach(score -> System.out.println(score));
        //降序
        scores.stream().sorted((o1, o2) -> Double.compare(o2, o1)).forEach(score -> System.out.println(score));
    }
}
