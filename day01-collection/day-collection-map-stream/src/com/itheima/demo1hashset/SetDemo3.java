package com.itheima.demo1hashset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo3 {
    public static void main(String[] args) {
        //目标:搞清楚TreeSet集合对于自定义对象的排序
        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        //Set<Teacher> teachers = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge()); 简化版

        teachers.add(new Teacher("小王", 18, 5000));
        teachers.add(new Teacher("小陈", 20, 2000));
        teachers.add(new Teacher("小张", 19, 3000));
        teachers.add(new Teacher("小wu", 21, 5000));

        System.out.println(teachers);

        //TreeSet集合默认不能给自定义对象排序,因为不知道大小规则
        //两个解决方法:
        //1.对象实现Comparable接口,重写compareTo方法,规定大小比较规则
        //2.public TreeSet(Comparator<? super E> comparator)集合自带比较器Comparator对象,指定比较规则
    }
}
