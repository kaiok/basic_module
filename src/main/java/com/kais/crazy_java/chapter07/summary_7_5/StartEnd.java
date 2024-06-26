package com.kais.crazy_java.chapter07.summary_7_5;

import lombok.var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kais
 * @date 2022.08.18. 17:37
 */
public class StartEnd {
    public static void main(String[] args) {
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        var regStr = "Java is very easy!";
        System.out.println("目标字符串是：" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + "子串的起始位置：" + m.start() + "，其结束位置：" + m.end());
        }
    }
}
