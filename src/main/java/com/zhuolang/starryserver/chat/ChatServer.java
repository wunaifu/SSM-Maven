package com.zhuolang.starryserver.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private static final int SERVER_PORT = 30000;
    // 使用CrazyitMap对象来保存每个客户名字和对应输出流之间的对应关系
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

    public void init() {
        try (
            // 建立监听的ServerSocket
            ServerSocket ss = new ServerSocket(SERVER_PORT);
        ) {
            // 采用死循环来不断地接收来自客户端的请求
            while (true) {
                Socket socket = ss.accept();
                new ChatServerThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败，是否端口"+SERVER_PORT+"已被占用？");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.init();
    }

}
