package com.kais.crazy_java.chapter07.summary_7_3;

import java.util.Objects;

/**
 * @author kais
 * @date 2022.08.18. 15:56
 */
public class ObjectsTest {
    // 定义一个obj变量，它的默认值是null
    static ObjectsTest obj;
    public static void main(String[] args) {
        // 输出一个null对象的hashCode值，输出0
        System.out.println(Objects.hashCode(obj));
        // 输出一个null对象的toString，输出null
        System.out.println(Objects.toString(obj));
        // 要求obj不能为null，如果obj为null则引发异常
        System.out.println(Objects.requireNonNull(obj, "obj参数不能是null！"));
    }
}
