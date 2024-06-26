package com.kais.double_colon;

import java.util.Arrays;
import java.util.List;

/**
 * @author kais
 * @date 2022.07.01. 11:03
 */
public class system_out_println_03 {

    public static void main(String[] args) {

        String[] array = {"aa","bb","cc"};
        List<String> list = Arrays.asList(array);
        // java 7
        for (String s : list ) {
            System.out.println(s);
        }

        /**
         * java 8
         * 说明：System.out是一个对象，而且是一个PrintStream类型的实例。println是PrintStream类中的一个非静态方法。
         *
         * System.out.println()的真正含义
         * out是System类中的一个静态属性，默认值为null，类型为PrintStream。System.out的实例化是通过System类中的initializeSystemClass
         * 方法完成的，在虚拟机加载的时候完成初始化
         */
        list.forEach(System.out::println);
    }

}
