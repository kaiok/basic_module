package com.kais.crazy_java.chapter07.summary_7_5;

import lombok.var;

import java.util.Arrays;

/**
 * @author kais
 * @date 2022.08.19. 13:21
 */
public class StringReg {
    public static void main(String[] args) {
        String[] msgs =
                {
                        "Java has regular expressions in 1.4",
                        "regular expressions now expressing in Java",
                        "Java represses oracular expressions"
                };
        for (var msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}