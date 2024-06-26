package com.kais.crazy_java.chapter14.summary_14_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.22. 16:13
 * 关闭整个类里的编译器警告
 */
@SuppressWarnings(value = "unchecked")
public class SuppressWarningsTest {
    public static void main(String[] args) {
        List<String> myList = new ArrayList();     // ①
    }
}