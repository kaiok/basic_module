package com.kais.crazy_java.chapter07.summary_7_1;

import lombok.var;

import java.util.Scanner;

/**
 * @author kais
 * @date 2022.08.18. 11:33
 */
public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        // System.in代表标准输入，就是键盘输入
        var sc = new Scanner(System.in);
        // 增加下面一行将只把回车作为分隔符
        // sc.useDelimiter("\n");
        // 判断是否还有下一个输入项
        while (sc.hasNext()) {
            // 输出输入项
            System.out.println("键盘输入的内容是：" + sc.next());
        }
    }
}