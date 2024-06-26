package com.kais.crazy_java.chapter06.summary_6_9;

/**
 * @author kais
 * @date 2022.08.16. 17:22
 */
public class GenderTest {
    public static void main(String[] args) {
        // 通过Enum的valueOf()方法来获取指定枚举类的枚举值
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        // 直接为枚举值的name实例变量赋值
        g.name = "女";
        // 直接访问枚举值的name实例变量
        System.out.println(g + "代表:" + g.name);
    }
}