package com.kais.crazy_java.chapter15.summary_15_5;

import lombok.var;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kais
 * @date 2022.08.25. 01:51
 */
public class RedirectIn {
    public static void main(String[] args) {
        try (
                var fis = new FileInputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java" +
                        "/com/kais/crazy_java/chapter15/summary_15_5/RedirectIn.java")) {
            // 将标准输入重定向到fis输入流
            System.setIn(fis);
            // 使用System.in创建Scanner对象，用于获取标准输入
            var sc = new Scanner(System.in);
            // 增加下面一行将只把回车作为分隔符
            sc.useDelimiter("\n");
            // 判断是否还有下一个输入项
            while (sc.hasNext()) {
                // 输出输入项
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
