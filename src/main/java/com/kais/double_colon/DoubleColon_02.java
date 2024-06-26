package com.kais.double_colon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author kais
 * @date 2022.07.01. 10:47
 */
public class DoubleColon_02 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.forEach(DoubleColon_02::print);
        System.out.println("====================等价输出");

        // 定位到调用方法的参数位置
        Consumer<String> stringConsumer = DoubleColon_02::print;
        // 遍历传递元素-定位处桌椅接收传递过来的各元素，并打印
        list.forEach(s -> stringConsumer.accept(s));

    }

    public static void print(String str){
        System.out.println("print vlistue:" + str);
    }

}
