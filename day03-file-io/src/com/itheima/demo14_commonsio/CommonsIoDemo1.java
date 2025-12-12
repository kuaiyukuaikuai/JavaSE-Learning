package com.itheima.demo14_commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIoDemo1 {
     public static void main(String[] args) throws IOException {
         //目标:掌握commons-io的常用方法
         FileUtils.copyFile(new File("day03-file-io\\src\\csb.txt"),new File("day03-file-io\\src\\csb2.txt"));
     }
}
