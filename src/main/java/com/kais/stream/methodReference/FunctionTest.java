package com.kais.stream.methodReference;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kais
 * @date 2022.07.01. 13:32
 * 测试自定义函数式接口的使用
 */
public class FunctionTest {

    public static String DateFormat(LocalDateTime dateTime,String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(dateTimeFormatter);
    }

    /**
     * 原来的操作流程
     * 1：自定义KiteFunctionImp实现类implements自定义的函数式接口类，实现其中的run方法
     * 2：创建KiteFunctionImp类对象，使用对象调用其中的run方法
     */
    @Test
    public void mainTest02() {
        LocalDateTime nowTime = LocalDateTime.now();
        String format = "yy-MM-dd HH:mm:ss";

        KiteFunctionImp kiteFunctionImp = new KiteFunctionImp();
        String run = kiteFunctionImp.run(nowTime, format);
        System.out.println("time: " + run);

    }


    /**
     * 使用匿名内部类
     */
    @Test
    public void mainTest03() {
        String run = new KiteFunction<LocalDateTime, String, String>() {
            @Override
            public String run(LocalDateTime dateTime, String s) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(s);
                return dateTime.format(dateTimeFormatter);
            }
        }.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

        System.out.println("time：" + run);
    }

    /**
     * 使用方法引用
     */
    @Test
    public void mainTest01() {

        // 使用自定义函数接口声明对象，并将DateFormat方法赋值给该对象
        KiteFunction<LocalDateTime, String, String> dateFormat = FunctionTest::DateFormat;
        // 函数式接口声明的对象调用run方法，方法参数为DateFormat方法参数
        String run = dateFormat.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("run:" + run);

    }

    /**
     * 使用lambda表达式
     * 1：使用（LocalDateTime dateTime, String patten) -> { } 这样的 Lambda 表达式直接返回方法引用
     * 2：再使用方法的引用调用run方法
     */
    @Test
    public void mainTest04() {
        String run = ((KiteFunction<LocalDateTime, String, String>) (dateTime, s) -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(s);
            return dateTime.format(dateTimeFormatter);
        }).run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

        System.out.println("time：" + run);
    }
}
