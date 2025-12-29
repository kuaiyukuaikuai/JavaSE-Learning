package com.kuaiyukuaikuai.demo6tcp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread {
    private Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //1.获取输入流,读取数据
            InputStream is = socket.getInputStream();
            //2.将输入流包装成特殊数据输入流
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                //3.读取数据
                String msg = dis.readUTF();
                System.out.println("服务端收到数据:" + msg);
                //客户端的ip和端口
                System.out.println("客户端ip:" + socket.getInetAddress().getHostAddress());
                System.out.println("客户端端口:" + socket.getPort());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
