package com.kais.crazy_java.chapter15.summary_15_3;

import lombok.var;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.24. 17:05
 * 下面程序使用FileInputStream来执行输入，并使用FileOutputStream来执行输出，用以实现复制FileOutputStreamTest.java文件的功能。
 */

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建字节输入流
                var fis = new FileInputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_3/FileOutputStreamTest.java");
                // 创建字节输出流
                var fos = new FileOutputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_3/newFile.txt")) {
            var bbuf = new byte[32];
            var hasRead = 0;
            // 循环从输入流中取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 每读取一次，即写入文件输出流，读了多少，就写多少。
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}