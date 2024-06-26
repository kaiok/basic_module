package com.kais.crazy_java.chapter15.summary_15_7;

import lombok.var;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author kais
 * @date 2022.08.25. 03:04
 * 下面程序使用了RandomAccessFile来访问指定的中间部分数据
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                var raf = new RandomAccessFile("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_7/RandomAccessFileTest.java", "r")) {
            // 获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
            // 移动raf的文件记录指针的位置
            raf.seek(300);
            var bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            var hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
                System.out.print(new String(bbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
