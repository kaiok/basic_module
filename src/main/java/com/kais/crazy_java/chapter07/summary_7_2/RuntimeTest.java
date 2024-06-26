package com.kais.crazy_java.chapter07.summary_7_2;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.18. 13:25
 */
public class RuntimeTest {
    public static void main(String[] args) {
        // 获取Java程序关联的运行时对象
        var rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors());
        System.out.println("空闲内存数：" + rt.freeMemory());
        System.out.println("总内存数：" + rt.totalMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());
        Runtime runtime = Runtime.getRuntime();

    }
}
