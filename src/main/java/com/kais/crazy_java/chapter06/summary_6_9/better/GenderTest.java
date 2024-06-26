package com.kais.crazy_java.chapter06.summary_6_9.better;

/**
 * @author kais
 * @date 2022.08.16. 17:43
 */
public class GenderTest {
    public static void main(String[] args) {
        Gender g = Gender.valueOf("FEMALE");
        g.setName("女");
        System.out.println(g + "代表:" + g.getName());
        // 此时设置name值时将会提示参数错误。
        g.setName("男");
        System.out.println(g + "代表:" + g.getName());
    }
}
