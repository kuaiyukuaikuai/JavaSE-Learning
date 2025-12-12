package com.itheima.demo2recursion;

import java.io.File;
import java.io.IOException;

public class FileSearchTest4 {
    public static void main(String[] args) {
        //目标:使用递归实现文件搜索
        try {
            File dir = new File("D:\\");
            searchFile(dir, "QQ.exe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归方法实现文件搜索
     *
     * @param dir     要搜索的目录
     * @param keyword 要搜索的关键字
     */
    public static void searchFile(File dir, String keyword) throws Exception {
//        1.判断极端情况
        if (dir == null || !dir.exists() || dir.isFile()) {
            return;
        }

        //2.获取目录下的所有一级文件或者文件夹对象
        File[] files = dir.listFiles();

        //3.判断当前目录下是否存在一级文件对象,存在才可以遍历
        if (files != null && files.length > 0) {
            //4.遍历一级文件对象
            for (File file : files) {
                //5.判断当前文件对象是否是文件
                if (file.isFile()) {
                    //6.判断文件名是否包含关键字
                    if (file.getName().contains(keyword)) {
                        System.out.println("找到文件:" + file.getAbsolutePath());
                        Runtime r=Runtime.getRuntime();
                        r.exec(file.getAbsolutePath());
                    }
                } else {
                    //7.递归搜索
                    searchFile(file, keyword);
                }
            }
        }
    }
}

