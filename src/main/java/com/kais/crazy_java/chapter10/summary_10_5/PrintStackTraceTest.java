package com.kais.crazy_java.chapter10.summary_10_5;

/**
 * @author kais
 * @date 2022.08.22. 15:38
 */
class SelfException extends RuntimeException {
    SelfException() {
    }
    SelfException(String msg) {
        super(msg);
    }
}
public class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }
    public static void firstMethod() {
        secondMethod();
    }
    public static void secondMethod() {
        thirdMethod();
    }
    public static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}
