package com.zhuolang.starryserver.nettest;

import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            System.out.println("是否可达：" + ip.isReachable(2000));
            System.out.println(ip.getHostAddress());
            InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println("本机是否可达:" + local.isReachable(5000));
            System.out.println(local.getCanonicalHostName());
            //获取InetAddress实例对应的全限定域名
            System.out.println(local.getHostAddress());

            System.out.println("*********************************");

            //将application/x-www-form-urlencoded字符串转换成普通字符串
            String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf8");
            System.out.println(keyWord);

            System.out.println("*********************************");

            //将普通字符串转换成application/x-www-form-urlencoded字符串
            String urlStr = URLEncoder.encode("疯狂java讲义", "GBK");
            System.out.println(urlStr);

            String keyWordUrlStr = URLDecoder.decode(urlStr, "utf8");
            System.out.println(keyWordUrlStr);

            System.out.println("*********************************");

            String urlStr1 = URLEncoder.encode("疯狂java讲义", "utf8");
            System.out.println(urlStr1);

            String keyWordUrlStr1 = URLDecoder.decode(urlStr1, "utf8");
            System.out.println(keyWordUrlStr1);

            //   out
            //   是否可达：true
            //   14.215.177.39
            //   本机是否可达:true
            //   eureka7001.com
            //   127.0.0.1
            //   *********************************
            //   疯狂java
            //   *********************************
            //   %B7%E8%BF%F1java%BD%B2%D2%E5
            //   ���java����
            //   *********************************
            //   %E7%96%AF%E7%8B%82java%E8%AE%B2%E4%B9%89
            //   疯狂java讲义

            System.out.println("****************下载*****************");
            String fileUrl = "http://localhost:8081/starry/img/e69ce244-fc71-499a-b276-798930fd8c38.zip";
            String fileName = UUID.randomUUID() + fileUrl.substring(fileUrl.lastIndexOf("."));
            // 初始化DownUtil对象
            final DownUtil downUtil = new DownUtil(fileUrl, fileName, 1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 开始下载
                        if (downUtil.download() <= 0) {
                            System.out.println("文件大小小于0，找不到资源");
                        } else {
                            double progress = downUtil.getCompleteRate();
                            System.out.println("进度条：" + String.format("%.4f", progress));
                            while (progress < 1) {
                                // 每隔0.1秒查询一次任务的完成进度
                                // GUI程序中可根据该进度来绘制进度条
                                System.out.println("已完成：" + downUtil.getCompleteRate());
                                try {
                                    Thread.sleep(100);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                progress = downUtil.getCompleteRate();
                                System.out.println("进度条：" + String.format("%.4f", progress));
                                if (progress <= 0) {
                                    System.out.println("进度小于0，网络差，找不到资源");
                                    break;
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
