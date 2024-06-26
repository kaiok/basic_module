package com.kais.crazy_java.chapter10.summary_10_4;

/**
 * @author kais
 * @date 2022.08.22. 15:28
 * 自定义异常类
 */
public class AuctionException extends Exception {
    // 无参数的构造器
    public AuctionException() {
    }       // ①

    // 带一个字符串参数的构造器
    public AuctionException(String msg)    // ②
    {
        super(msg);
    }
}