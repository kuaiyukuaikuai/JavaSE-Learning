package com.kuaiyukuaikuai.demo6tcp4;

import java.io.*;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable {
    private Socket socket;
    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 给当前对应浏览器管道响应一个网页数据回去
            OutputStream os = socket.getOutputStream();
            //通过字节输出流包装写出去数据给浏览器
            //将字节输出流包装成打印流，方便写数据
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();//换行
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<body>");
            ps.println("<h1>欢迎来到Servlet</h1>");
            ps.println("</body>");
            ps.println("</head>");
            ps.println("</html>");
            ps.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("客户端退出!"+socket.getInetAddress().getHostAddress());
        }
    }
}
