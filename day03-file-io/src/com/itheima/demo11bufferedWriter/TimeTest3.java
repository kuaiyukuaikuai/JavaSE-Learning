package com.itheima.demo11bufferedWriter;

import java.io.*;

public class TimeTest3 {
    private static final String SRC_FILE = "D:\\视频\\大疆actiong3拍摄\\2025.11.22福建(高清)\\第二个沙滩游玩 (2)_1.mp4";
    private static final String DEST_FILE = "D:\\视频\\";

    public static void main(String[] args) {
        //copyFile();//太慢了
        copyFile2();
        copyFile3();
        copyFile4();

    }

    public static void copyFile() {
        //获取当前 时间
        long start = System.currentTimeMillis();
        try (OutputStream fos = new FileOutputStream(DEST_FILE + "1.mp4");
             InputStream fis = new FileInputStream(SRC_FILE);
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }


    //
    private static void copyFile2() {
        long start = System.currentTimeMillis();
        try (OutputStream fos = new FileOutputStream(DEST_FILE + "2.mp4");
             InputStream fis = new FileInputStream(SRC_FILE);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }

    private static void copyFile3() {
        long start = System.currentTimeMillis();
        try (
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(DEST_FILE + "3.mp4"));
                InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }

    private static void copyFile4() {
        long start = System.currentTimeMillis();
        try (
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(DEST_FILE + "4.mp4"));
                InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时:" + (end - start) / 1000 + "秒");
    }
}
