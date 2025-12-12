package com.itheima.demo1hashset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    //1.重写compareTo方法
    //t2.compareTo(t1)    由集合默认调用
    //t2 == this   t1 == o
    //如果认为左边大于右边返回正整数,认为左边小于右边返回负整数,认为左边等于右边返回0
    //默认升序
    @Override
    public int compareTo(Teacher o) {
        //按照年龄升序
//        if(this.age > o.age) {
//            return 1;
//        }
//        if(this.age < o.age) {
//            return -1;
//        }
//            return 0;
        return this.age - o.age;
    }

    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary='" + salary + '\'' +
                '}'+"\n";
    }
}
