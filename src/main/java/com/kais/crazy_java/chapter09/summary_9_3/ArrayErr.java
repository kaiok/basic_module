package com.kais.crazy_java.chapter09.summary_9_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.22. 11:42
 */
public class ArrayErr {
    public static void main(String[] args) {
        // 定义一个Integer数组
        Integer[] ia = new Integer[5];
        // 可以把一个Integer[]数组赋给Number[]变量
        Number[] na = ia;
        // java允许将Double类型数据存储到Number类对象中，下面代码编译正常，但运行时会引发ArrayStoreException异常
        // 因为0.5并不是Integer
        na[0] = 0.5;   // ①
        List<Integer> iList = new ArrayList<>();
        // 下面代码导致编译错误
//		List<Number> nList = iList;
    }
}