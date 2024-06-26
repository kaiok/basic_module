package com.kais.crazy_java.chapter06.otherSummary;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.10. 14:07
 */
public interface Output {

    /**
     * 接口里定义的成员变量只能是常量
     * 成员变量默认使用public static final修饰
     */
    public static final int MAX_CACHE_LINE = 50;

    /**
     * 接口里定义的普通方法只能是public的抽象方法
     */
    void out();

    void getData(String msg);

    /**
     * 在接口中定义默认方法，需要使用default修饰
     */
    default void print(String... msgs) {
        for (var msg : msgs) {
            System.out.println(msg);
        }
    }

    // 在接口中定义默认方法，需要使用default修饰
    default void test() {
        System.out.println("默认的test()方法");
    }

    // 在接口中定义类方法，需要使用static修饰
    static String staticTest() {
        return "接口里的类方法";
    }

    // 定义私有方法
    default void foo() {
        System.out.println("foo私有方法");
    }

    // 定义私有静态方法
    static void bar() {
        System.out.println("bar私有静态方法");
    }
}
