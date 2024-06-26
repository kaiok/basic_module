package com.kais.crazy_java.chapter15.summary_15_3;

import lombok.var;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.23. 14:36
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流
        var fis = new FileInputStream("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_3/FileInputStreamTest.java");
        // 创建一个长度为1024的“竹筒”
        var bbuf = new byte[1024];
        // 用于保存实际读取的字节数
        var hasRead = 0;
        // 使用循环来重复“取水”过程
        while ((hasRead = fis.read(bbuf)) > 0) {
            // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
            System.out.print(new String(bbuf, 0, hasRead));
        }
        // 关闭文件输入流，放在finally块里更安全
        fis.close();
    }
}
