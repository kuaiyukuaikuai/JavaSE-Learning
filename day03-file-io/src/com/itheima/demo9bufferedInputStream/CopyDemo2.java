package com.itheima.demo9bufferedInputStream;

import java.io.*;

public class CopyDemo2 {
    public static void main(String[] args) {
        copyFile("day03-file-io\\src\\dilei02.txt", "day03-file-io\\src\\dilei04.txt");
    }

    public static void copyFile(String srcPath, String destPath) {
        try (
                //这里只能放置资源对象,用完后最终会自动调用close()方法
                //把低级流升级为高级流
                InputStream fis = new FileInputStream(srcPath);
                InputStream bis = new BufferedInputStream(fis);
                OutputStream fos = new FileOutputStream(destPath);
                OutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            System.out.println("文件复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}