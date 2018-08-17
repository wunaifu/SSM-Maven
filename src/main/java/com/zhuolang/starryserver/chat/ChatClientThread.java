package com.zhuolang.starryserver.chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread{
    // 该客户端线程负责处理的输入流
    BufferedReader br = null;

    // 使用一个网络输入流来创建客户端线程
    public ChatClientThread(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void run() {
        try {
            String line = null;
            // 不断地输入流中读取数据，并将这些数据打印输出
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                /*
                本例仅打印了从服务器端读到的内容。实际上，此处的情况可以更复杂：如
                果希望客户端能看到聊天室的用户列表，则可以让服务器端在每次有用户登
                录、用户退出时，将所有的用户列表信息都向客户端发送一遍。为了区分服
                务器端发送的是聊天信息，还是用户列表，服务器端也应该在要发送的信息
                前、后都添加一定的协议字符串，客户端则根据协议字符串的不同而进行不
                同的处理！
                更复杂的情况：
                如果两端进行游戏，则还有可能发送游戏信息，例如两端进行五子棋游戏，
                则需要发送下棋坐标信息等，服务器端同样在这些下棋坐标信息前、后添加
                协议字符串后再发送，客户端就可以根据该信息知道对手的下棋坐标。
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭该线程对应的输入流
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
