package com.kais.crazy_java.chapter15.summary_15_4;

import lombok.var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kais
 * @date 2022.08.24. 17:36
 */
public class KeyInTest {
    public static void main(String[] args) {
        try (
                // 将Sytem.in对象转换成Reader对象(字符流)
                var reader = new InputStreamReader(System.in);
                // 将普通Reader包装成BufferedReader（readLine支持读取行内容）
                var br = new BufferedReader(reader)
        ) {
            String line = null;
            // 采用循环方式来一行一行的读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为"exit"，程序退出
                if (line.equals("exit")) {
                    System.exit(1);
                }
                // 打印读取的内容
                System.out.println("输入内容为:" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}