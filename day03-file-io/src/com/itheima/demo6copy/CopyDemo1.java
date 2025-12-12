package com.itheima.demo6copy;

import java.io.*;

public class CopyDemo1 {
    public static void main(String[] args) {
        copyFile("day03-file-io\\src\\dilei02.txt", "day03-file-io\\src\\dilei04.txt");
    }
    public static void copyFile(String srcPath, String destPath)  {
        try(
                //这里只能放置资源对象,用完后最终会自动调用close()方法
                InputStream fis = new FileInputStream(srcPath);
                OutputStream fos = new FileOutputStream(destPath);
                )
            {
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                System.out.println("文件复制完成！");
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*  public static void copyFile(String srcPath, String destPath) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            System.out.println("文件复制完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } */
}