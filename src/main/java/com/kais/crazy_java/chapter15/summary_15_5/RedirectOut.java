package com.kais.crazy_java.chapter15.summary_15_5;

import lombok.var;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author kais
 * @date 2022.08.25. 01:49
 */
public class RedirectOut {
    public static void main(String[] args) {
        try (
                // 一次性创建PrintStream输出流
                var ps = new PrintStream(new FileOutputStream("/Users/kais/projects/AppleProject/basic_module" +
                        "/src/main/java/com/kais/crazy_java/chapter15/summary_15_5/out.txt"))) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            // 向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
