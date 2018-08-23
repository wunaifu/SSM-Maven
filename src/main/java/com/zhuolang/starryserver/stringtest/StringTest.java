package com.zhuolang.starryserver.stringtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) {
        String str = "hello,java!";
        // 贪婪模式的正则表达式
        System.out.println(str.replaceFirst("\\w*","■"));
        // 勉强模式的正则表达式
        System.out.println(str.replaceFirst("\\w*?","■"));

        // 使用字符串模拟从网络上得到的网页源码
        String str1 = "我想求购一本《疯狂java讲义》，尽快联系我13500006666"
                + "交朋友，电话号码是13611125565"
                + "交朋友，电话号码是14611125565"
                + "出售二手电脑，联系方式15899903312";
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        // 该正则表达式只抓取13X和15X段的手机号
        // 实际要抓取哪些电话号码，只要修改正则表达式即可
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str1);
        while (m.find()) {
            System.out.println(m.group() + "子串的起始位置："
                    + m.start() + ",其结束位置：" + m.end());

        }

        // 邮箱正则表达式判断
        System.out.println("***********************邮箱正则表达式判断***********************");
        String[] mails = {
                "kongyeeku@163.com",
                "kongyeeku@gmail.com",
                "ligang@crazyit.org",
                "ligang@qq.com",
                "ligangqq.com",
                "wawa@abc.xx"
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|\\w+)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是"
                    + "一个有效的邮件地址");
            System.out.println(result);
        }

        // 敏感词替换字符
        System.out.println("******************敏感词替换字符******************");
        String[] msgs = {
                "系统文件一般分为两种格式：ISO格式和GHO格式。ISO格式又分为原版系统和" +
                        "GHOST封装系统两种。用解压软件WinRAR解压后大于600M（WIN7一般2G）" +
                        "以上的.GHO文件的是GHOST封装系统，PE里的U大师智能装机PE版软件可以直" +
                        "接支持还原安装。如果解压后没有大于600M以上的GHO文件则是原版ISO格式" +
                        "系统，要用安装原版XP和WIN7的方法来安装如遇卡住可能会是网速的问题"
                ,"你们好啊，系统，你这是原版的吗？"
        };
        Pattern p = Pattern.compile("(系统)|(原版)");
        Matcher matcher1 = null;
        for (int i = 0; i < msgs.length; i++) {
            if (matcher1 == null) {
                matcher1 = p.matcher(msgs[i]);
            } else {
                matcher1.reset(msgs[i]);
            }
            String s = matcher1.replaceAll("**");
            System.out.println(s);
        }
    }
}
