package com.itheima.demo3genericity;

public class StudentData implements Data<Student>{
    @Override
    public void add(Student student) {
        System.out.println("添加学生成功");
    }

    @Override
    public void delete(Student student) {
        System.out.println("删除学生成功");
    }

    @Override
    public void update(Student student) {
        System.out.println("修改学生成功");
    }

    @Override
    public Student query(int id) {
        return null;
    }

}
