package com.kais.crazy_java.chapter15.summary_15_4;

import lombok.var;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author kais
 * @date 2022.08.24. 17:16
 */
public class PrintStreamTest {
    public static void main(String[] args) {

        try (
                // 首先定义一个节点流FileOutputStream
                var fos = new FileOutputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_4/PrintStreamTest.java");
                // 使用处理流包装节点流对象
                var ps = new PrintStream(fos)) {

                    // 使用PrintStream执行输出
                    ps.println("普通字符串");
                    // 直接使用PrintStream输出对象
                    ps.println(new PrintStreamTest());

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
    }
}
