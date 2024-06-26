package com.kais.crazy_java.chapter15.summary_15_6;

import lombok.var;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author kais
 * @date 2022.08.25. 02:03
 */
public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        // 运行java ReadStandard命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac /Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_6/ReadStandard.java");
        try (
                // 以p进程的输出流创建PrintStream对象
                // 这个输出流对本程序是输出流，对p进程则是输入流
                var ps = new PrintStream(p.getOutputStream())) {
            // 向ReadStandard程序写入内容，这些内容将被ReadStandard读取
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
    }
}
