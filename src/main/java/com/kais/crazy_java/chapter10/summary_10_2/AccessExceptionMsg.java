package com.kais.crazy_java.chapter10.summary_10_2;

import lombok.var;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.22. 14:21
 */
public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            var fis = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}