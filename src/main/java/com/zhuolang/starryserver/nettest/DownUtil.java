package com.zhuolang.starryserver.nettest;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DownUtil {

    // 定义下载资源的路径
    private String path;
    // 指定所下载的文件的保存位置
    private String targetFile;
    // 定义需要使用多少个线程下载资源
    private int threadNum;
    // 定义下载的线程对象
    private DownThread[] threads;
    // 定义下载的文件的总大小
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        // 初始化threadNum数组
        threads = new DownThread[threadNum];
    }

    public int download() throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty(
                "Accept",
                "image/gif,image/jpeg,image/pjpeg,image/pjpeg,"
                        + "application/x-shockwave-flash,application/xaml+xml,"
                        + "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
                        + "application/x-ms-application,application/vnd.ms-excel,"
                        + "application/vnd.ms-powerpoint,application/msword,*/*"
        );
        conn.setRequestProperty("Accept-Language","zh-CN");
        conn.setRequestProperty("Charset","UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        // 得到文件大小
        fileSize = conn.getContentLength();
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        // 设置本地文件的大小
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++) {
            // 计算每个线程下载的开始位置
            int startPos = i * currentPartSize;
            // 每个线程使用一个RandomAccessFile进行下载
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            // 定位该线程的下载位置
            currentPart.seek(startPos);
            // 创建下载线程
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            // 启动下载线程
            threads[i].start();

        }
        System.out.println("文件大小：" + fileSize);
        return fileSize;
    }

    // 获取下载的完成百分比
    public double getCompleteRate() {
        // 统计多个线程已经下载的总大小
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        // 返回已经完成的百分比
        return sumSize * 1.0 / fileSize;
    }

    private class DownThread extends Thread{
        // 当前线程的下载位置
        private int startPos;
        // 定义当前线程负责下载的文件大小
        private int currentPartSize;
        // 当前线程需要下载的文件块
        private RandomAccessFile currentPart;
        // 定义该线程已下载的字节数
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty(
                        "Accept",
                         "image/gif,image/jpeg,image/pjpeg,image/pjpeg,"
                        + "application/x-shockwave-flash,application/xaml+xml,"
                        + "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
                        + "application/x-ms-application,application/vnd.ms-excel,"
                        + "application/vnd.ms-powerpoint,application/msword,*/*"
                );
                conn.setRequestProperty("Accept-Language","zh-CN");
                conn.setRequestProperty("Charset","UTF-8");
                InputStream inStream = conn.getInputStream();
                // 跳过startPos个字节，表明该线程只下载自己负责的那部分文件
                inStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                // 读取网络数据，并写入本地文件
                while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    // 累计该线程下载的总大小
                    length += hasRead;
                }
                currentPart.close();
                inStream.close();

            }catch (FileNotFoundException e){
                System.out.println("没有找到资源文件，请检查文件链接");
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("****************下载*****************");
//        List<String> stringList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            stringList.add("1821911162" + i);
//        }
//        for (int i = 0; i < stringList.size(); i++) {
            String fileUrl = "http://other.web.nf01.sycdn.kuwo.cn/resource/n1/68/9/4199826850.mp3";
            String fileName = "sadfasd"+ fileUrl.substring(fileUrl.lastIndexOf("."));
            // 初始化DownUtil对象
            DownUtil downUtil = new DownUtil(fileUrl, fileName, 1);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
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
//                }
//            }).start();
//        }

    }

}


