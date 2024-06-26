package com.kais.crazy_java.chapter15.summary_15_3;

import lombok.var;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.23. 15:00
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try (
            // 创建字符输入流
            var fr = new FileReader("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_3/FileReaderTest.java")) {
            // 创建一个长度为32的“竹筒”
            var cbuf = new char[32];
            // 用于保存实际读取的字符数
            var hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = fr.read(cbuf)) > 0) {
                // 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
