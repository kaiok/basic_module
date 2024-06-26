package com.kais.crazy_java.chapter15.summary_15_4;

import lombok.var;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * @author kais
 * @date 2022.08.24. 17:47
 * 推回输入/输出流，找出文件中"new_PushbackReader"内容，找到后只打印目标字符串之前的内容
 */
public class PushbackTest {
    public static void main(String[] args) {
        try (
                // 创建一个PushbackReader对象，指定推回缓冲区的长度为64
                var pr = new PushbackReader(new FileReader("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_4/PushbackTest.java"), 64)
        ) {
            // 每次读取文件中32个字节的内容，/n（换行符为占一个char类型空间，String类型占两个字节）
            var buf = new char[32];
            // 用以保存上次读取的字符串内容
            var lastContent = "";
            var hasRead = 0;
            // 循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
                // 将读取的内容转换成字符串
                var content = new String(buf, 0, hasRead);

//                System.out.println("\t循环读取的内容为：" + content);

                var targetIndex = 0;
                // 将上次读取的字符串和本次读取的字符串拼起来，可能上次读取的内容为目标字符串的一部分
                // 查看是否包含目标字符串, 如果包含目标字符串
                // 返回的为目标字符串在(lastContent + content)中的索引，可能超过32个字节
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {

//                    System.out.println("本次读取的字符串拼接上次读取的字符串：" + lastContent + content);

                    // 将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    // 当索引超过32个字节的时候，重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    // 再次读取指定长度的内容（就是目标字符串之前的内容），读取缓冲区中的字符串
                    pr.read(buf, 0, targetIndex);
                    // 打印读取的内容
                    System.out.print(new String(buf, 0, targetIndex));
                    // 打印完目标字符串之前的内容，即退出程序
                    System.exit(0);
                } else {
                    // 打印上次读取的内容
                    System.out.print(lastContent);
                    // 将本次内容设为上次读取的内容
                    lastContent = content;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}