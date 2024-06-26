package com.kais.crazy_java.chapter07.summary_7_1;

import lombok.var;

import java.io.File;
import java.util.Scanner;

/**
 * @author kais
 * @date 2022.08.18. 11:38
 */
public class ScannerFileTest {
    public static void main(String[] args)  throws Exception {
        // 将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
        var sc = new Scanner(new File("ArgsTest.java"));
        System.out.println("ScannerFileTest.java文件内容如下：");
        // 判断是否还有下一行
        while (sc.hasNextLine()) {
            // 输出文件中的下一行
            System.out.println(sc.nextLine());
        }
    }
}
