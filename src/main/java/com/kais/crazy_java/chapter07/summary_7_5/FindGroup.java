package com.kais.crazy_java.chapter07.summary_7_5;

import lombok.var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kais
 * @date 2022.08.18. 17:34
 */
public class FindGroup {
    public static void main(String[] args) {
        // 使用字符串模拟从网络上得到的网页源码
        var str = "我想求购一本《疯狂Java讲义》，尽快联系我13500006666"
                + "交朋友，电话号码是13611125565"
                + "出售二手电脑，联系方式15899903312 鞍山市16899903312";
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        // 该正则表达式只抓取13X和15X段的手机号，
        // 实际要抓取哪些电话号码，只要修改正则表达式即可。
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        // 将所有符合正则表达式的子串（电话号码）全部输出
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}