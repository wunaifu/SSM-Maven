package com.zhuolang.starryserver.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        //Socket socket = new Socket("127.0.0.1", 30000);
        // 创建一个无连接的Socket
        Socket socket = new Socket();
        // 让该Socket连接到远程服务器，如果经过10秒还没有连接上，则认为连接超时
        socket.connect(new InetSocketAddress("127.0.0.1", 30000),10000);
        // 设置10秒之后即认为超时
        socket.setSoTimeout(10000);
        // 将Socket对应的输入流包装成BufferedReader
        BufferedReader br= new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        try {
            // 使用Scanner来读取网络输入流中的数据
//            Scanner scan = new Scanner(socket.getInputStream());
//            String line1 = scan.nextLine();
//            System.out.println("来自服务器的数据1：" + line1);
            // 进行普通IO操作
            String line = br.readLine();
            System.out.println("来自服务器的数据：" + line);
        } catch (SocketTimeoutException ex) {
            //捕获超时，对异常进行处理
            System.out.println("读取数据超时！");
        }
        // 关闭输入流，关闭Socket
        br.close();
        socket.close();

    }
}
