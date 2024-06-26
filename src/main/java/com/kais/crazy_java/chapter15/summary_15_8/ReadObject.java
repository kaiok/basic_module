package com.kais.crazy_java.chapter15.summary_15_8;

import lombok.var;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author kais
 * @date 2022.08.25. 03:24
 */
public class ReadObject {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("/Users/kais/projects/AppleProject/" +
                        "basic_module/src/main/java/com/kais/crazy_java/chapter15/summary_15_8/object.txt"))) {
            // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
            var p = (Person) ois.readObject();
            System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
