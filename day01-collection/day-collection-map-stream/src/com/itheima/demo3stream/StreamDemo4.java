package com.itheima.demo3stream;

import com.itheima.demo1hashset.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("小王", 18, 5000));
        teachers.add(new Teacher("小张", 19, 6000));
        teachers.add(new Teacher("大李", 17, 7000));
        teachers.add(new Teacher("小黑", 18, 5000));
        teachers.add(new Teacher("大白", 18, 9000));
        teachers.add(new Teacher("大王", 18, 8000));

        teachers.stream()
                .filter(t -> t.getAge() > 17)
                .filter(t -> t.getSalary() > 5000)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");

        Optional<Teacher> max = teachers.stream().max((t1, t2) -> Double.compare(t1.getSalary(),t2.getSalary()));
        Teacher maxTeacher = max.get();
         System.out.println(maxTeacher);
        System.out.println("------------------------------------------------");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张小三");
        list.add("张三丰");
        list.add("三张三");
        list.add("张三三三");
        list.add("张三三三三");
        list.add("三三三三");
        list.add("三三三三三三");
        Stream<String> s1=list.stream().filter(s->s.startsWith("张"));
        List<String> list1=s1.collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("------------------------------------------------");
        //收集到Map集合,键是老师名称,值是老师薪水
        //简化版
        //Map<String, Double> map = teachers.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        Map<String, Double> map = teachers.stream().collect(Collectors.toMap(new Function<Teacher, String>() {
            @Override
            public String apply(Teacher teacher) {
                return teacher.getName();
            }
        }, new Function<Teacher, Double>() {
            @Override
            public Double apply(Teacher teacher) {
                return teacher.getSalary();
            }
        }));
    }
}
