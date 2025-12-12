package com.itheima.demo11bufferedWriter;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedTest2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("day03-file-io\\src\\csb.txt"))) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
