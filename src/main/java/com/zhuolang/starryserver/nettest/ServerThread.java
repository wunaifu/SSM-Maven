package com.zhuolang.starryserver.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable{

    // 定义当前线程所处理的Socket
    Socket s = null;
    // 该线程所处理的Socket对应的输入流
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        // 初始化该Socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try {

            String content = null;
            // 采用循环不断地从Socket中读取客户端发送过来的数据
            while ((content = readFromClient()) != null) {
                System.out.println("服务器" + content);
                // 遍历socketList中的每个Socket
                // 将读到的内容向每个Socket发送一次
                for (Socket s : MyServer.socketList) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 定义读取客户端数据的方法
    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            // 删除该socket
            MyServer.socketList.remove(s);
        }
        return null;
    }
}
