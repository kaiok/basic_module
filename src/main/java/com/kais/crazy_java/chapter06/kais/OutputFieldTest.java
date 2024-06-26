package com.kais.crazy_java.chapter06.kais;

import com.kais.crazy_java.chapter06.otherSummary.Output;

/**
 * @author kais
 * @date 2022.08.10. 14:16
 */
public class OutputFieldTest {

    public static void main(String[] args) {
        // 访问另一个包中的Output接口的MAX_CACHE_LINE
        System.out.println(Output.MAX_CACHE_LINE);
        // 下面语句将引起"为final变量赋值"的编译异常
//         Output.MAX_CACHE_LINE = 20;
        // 使用接口来调用类方法
        System.out.println(Output.staticTest());
    }

}
