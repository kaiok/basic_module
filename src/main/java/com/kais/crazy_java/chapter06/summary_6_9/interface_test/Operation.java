package com.kais.crazy_java.chapter06.summary_6_9.interface_test;

/**
 * @author kais
 * @date 2022.08.17. 14:46
 * 包含抽象方法的枚举类，编译后生成5个.class文件
 * Operation\4个枚举值的匿名内部类
 */
public enum Operation {
    PLUS {
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double eval(double x, double y) {
            return x / y;
        }
    };

    // 为枚举类定义一个抽象方法
    // 这个抽象方法由不同的枚举值提供不同的实现
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 4));
        System.out.println(Operation.MINUS.eval(5, 4));
        System.out.println(Operation.TIMES.eval(5, 4));
        System.out.println(Operation.DIVIDE.eval(5, 4));
    }
}
