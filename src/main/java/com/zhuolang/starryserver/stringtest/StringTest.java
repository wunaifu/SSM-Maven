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

//    一些常用的正则匹配规则
//
//    匹配中文字符的正则表达式： [u4e00-u9fa5]
//            　　评注：匹配中文还真是个头疼的事，有了这个表达式就好办了
//　　匹配双字节字符(包括汉字在内)：[^x00-xff]
//            　　评注：可以用来计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
//            　　匹配空白行的正则表达式：ns*r
//　　评注：可以用来删除空白行
//　　匹配HTML标记的正则表达式：<(S*?)[^>]*>.*?|<.*? />
//            　　评注：网上流传的版本太糟糕，上面这个也仅仅能匹配部分，对于复杂的嵌套标记依旧无能为力
//　　匹配首尾空白字符的正则表达式：^s*|s*$
//　　评注：可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式
//　　匹配Email地址的正则表达式：w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*
//            　　评注：表单验证时很实用
//　　匹配网址URL的正则表达式：[a-zA-z]+://[^s]*
//            　　评注：网上流传的版本功能很有限，上面这个基本可以满足需求
//　　匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
//　　评注：表单验证时很实用
//　　匹配国内电话号码：d{3}-d{8}|d{4}-d{7}
//　　评注：匹配形式如 0511-4405222 或 021-87888822
//            　　匹配腾讯QQ号：[1-9][0-9]{4,}
//　　评注：腾讯QQ号从10000开始
//　　匹配中国邮政编码：[1-9]d{5}(?!d)
//            　　评注：中国邮政编码为6位数字
//　　匹配身份证：d{15}|d{18}
//　　评注：中国的身份证为15位或18位
//　　匹配ip地址：d+.d+.d+.d+
//            　　评注：提取ip地址时有用
}
