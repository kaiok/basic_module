package com.kais.stream.methodReference;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * @author kais
 * @date 2022.07.01. 11:39
 * 方法引用
 */
public class MethodReferences_01 {

    public static void main(String[] args) {

        /**
         * 1：方法引用的出现，使得我们可以
         *      将一个方法赋给一个变量
         *      或者作为参数传递给另外一个方法
         * ::双冒号作为方法引用的符号，比如下面这两行语句，引用 Integer类的 parseInt方法
         *
         * 2：什么样的方法可以被引用？
         *      ：任何有办法访问到的方法都可以被引用
         *    返回值的类型？
         *      ：返回值的类型是Java8专门定义的函数式接口，这类接口使用@FunctionlInterface注解标注，比如Function、Comparator、IntBinaryOperator
         *      即：其实不止这两个，只要是在某个函数式接口中声明了这样的方法：两个参数，参数类型是 int或者泛型，并且返回值是 int或者泛型的，都可以完美接收
         */
        /**
         * 将一个方法赋给一个变量
         */
        // Integer.parseInt作用是将()内的String类型字符串转化为int类型
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("10");
        System.out.println("apply = " + apply);

        // String.valueOf(int i) : 将 int 变量 i 转换成字符串
        Function<Integer, String> consumer = String::valueOf;
        String string = consumer.apply(23);
        System.out.println("string = " + string);

        Comparator<Integer> comparator = Integer::compare;
        int result = comparator.compare(10,100);
        System.out.println("result = " + result);

        IntBinaryOperator intBinaryOperator = Integer::compare;
        int returnResult = intBinaryOperator.applyAsInt(10,100);
        System.out.println("returnResult = " + returnResult);
    }

}
