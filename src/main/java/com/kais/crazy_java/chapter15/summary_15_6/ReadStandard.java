package com.kais.crazy_java.chapter15.summary_15_6;

import lombok.var;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author kais
 * @date 2022.08.25. 02:04
 */
// 定义一个ReadStandard类，该类可以接受标准输入，
// 并将标准输入写入out.txt文件。
class ReadStandard {
    public static void main(String[] args) {
        try (
                // 使用System.in创建Scanner对象，用于获取标准输入
                var sc = new Scanner(System.in);
                var ps = new PrintStream(new FileOutputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_6/out.txt"))) {
            // 增加下面一行将只把回车作为分隔符
            sc.useDelimiter("\n");
            // 判断是否还有下一个输入项
            while (sc.hasNext()) {
                // 输出输入项
                ps.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

