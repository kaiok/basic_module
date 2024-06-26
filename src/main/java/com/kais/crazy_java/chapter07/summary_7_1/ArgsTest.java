package com.kais.crazy_java.chapter07.summary_7_1;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.18. 11:30
 */
public class ArgsTest {
    public static void main(String[] args) {
        // 输出args数组的长度
        System.out.println(args.length);
        // 遍历args数组的每个元素
        for (var arg : args) {
            System.out.println(arg);
        }
    }
}
