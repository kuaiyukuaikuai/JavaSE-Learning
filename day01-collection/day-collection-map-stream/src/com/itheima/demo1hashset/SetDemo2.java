package com.itheima.demo1hashset;

import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {
    public static void main(String[] args) {
        Student s1=new Student("小王",18,"北京","13192961120");
        //创建s2、s3、s4,数据要不重复
        Student s2=new Student("小张",18,"南京","13822030696");
        Student s3=new Student("小王",18,"北京","13192961120");
        Student s4=new Student("小张",18,"南京","13822030696");
        Set<Student> set = new HashSet<>();//不重复的
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        System.out.println(set);//输出全部4个对象(地址不一样)

        //如果希望Set集合认为两个内容一样的对象是重复的,必须重写对象的hashCode()和equals()方法
        //重写方法后输出2个对象

    }
}
