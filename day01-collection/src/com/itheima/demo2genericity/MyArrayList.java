package com.itheima.demo2genericity;

import java.util.ArrayList;

public class MyArrayList<E> {

    private ArrayList list = new ArrayList();

    public void add(E e) {
        System.out.println("add");
        list.add(e);
    }

    public boolean remove(E e) {
        System.out.println("remove");
        return list.remove(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
