package com.kais.crazy_java.chapter15.summary_15_8;

import lombok.var;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author kais
 * @date 2022.08.25. 03:19
 * 下面程序使用ObjectOutputStream将一个Person对象写入磁盘文件。
 */

public class WriteObject {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                var oos = new ObjectOutputStream(new FileOutputStream("/Users/kais/projects/AppleProject/" +
                        "basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_8/object.txt"))) {
            var per = new Person("孙悟空", 500);
            // 将per对象写入输出流
            oos.writeObject(per);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}