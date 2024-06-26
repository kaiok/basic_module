package com.kais.double_colon;

import java.util.Arrays;
import java.util.List;

/**
 * @author kais
 * @date 2022.07.01. 10:22
 */
public class OriginalWay_01 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        for (String string : strings) {
            OriginalWay_01.printValue(string);
        }
        System.out.println("================等价输出");

        strings.forEach(s -> {OriginalWay_01.printValue(s);});

    }

    public static void printValue(String str){
        System.out.println("print value:" + str);
    }

}
