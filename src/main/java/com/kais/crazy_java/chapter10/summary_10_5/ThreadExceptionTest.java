package com.kais.crazy_java.chapter10.summary_10_5;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.22. 15:55
 */
public class ThreadExceptionTest implements Runnable {
    @Override
    public void run() {
        firstMethod();
    }
    public void firstMethod() {
        secondMethod();
    }
    public void secondMethod() {
        var a = 5;
        var b = 0;
        var c = a / b;
    }
    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }
}