package com.kais.crazy_java.chapter14.summary_14_3;

/**
 * @author kais
 * @date 2022.08.22. 16:39
 */
public class MyTest {
    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m1() {
    }

    public static void m2() {
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m3() {
        throw new IllegalArgumentException("参数出错了！");
    }

    public static void m4() {
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m5() {
    }

    public static void m6() {
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m7() {
        throw new RuntimeException("程序业务出现异常！");
    }

    public static void m8() {
    }
}
