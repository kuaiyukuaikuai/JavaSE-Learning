package com.kuaiyukuaikuai.demo6tcp4;

import com.kuaiyukuaikuai.demo6tcp3.ServerReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ServerDemo {
    private static int connectionCount = 0;
    private static Set<String> uniqueConnections = new HashSet<>();
    public static void main(String[] args) throws IOException {
        //目标:BS架构
        //1.创建一个ServerSocket对象,构造方法中绑定服务端的端口号
        System.out.println("服务器启动...");
        ServerSocket ss = new ServerSocket(8999);//8888为监听端口

        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            System.out.println("等待客户端连接...");
            Socket socket = ss.accept();
            String clientInfo = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();

            if (!uniqueConnections.contains(clientInfo)) {
                uniqueConnections.add(clientInfo);
                connectionCount++;
                System.out.println("新客户端连接，总数：" + connectionCount + ", IP:" + socket.getInetAddress().getHostAddress());
            } else {
                System.out.println("重复连接，IP:" + socket.getInetAddress().getHostAddress());
            }

            pool.execute(new ServerReaderRunnable(socket));
        }
    }
}
