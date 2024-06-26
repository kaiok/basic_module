package com.kais.crazy_java.chapter06.summary_6_10;

import lombok.var;

import java.lang.ref.WeakReference;

/**
 * @author kais
 * @date 2022.08.18. 10:57
 */
public class ReferenceTest {
    public static void main(String[] args) throws Exception {
        // 创建一个字符串对象，不要使用String str = "疯狂Java讲义"；否则系统会使用常量池管理
        // 这个字符串直接量（强引用），系统不会回收这个字符串直接量
        var str = new String("疯狂Java讲义");
        // 创建一个弱引用，让此弱引用引用到"疯狂Java讲义"字符串
        var wr = new WeakReference(str);  // ①
        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;   // ②
        // 取出弱引用所引用的对象
        System.out.println(wr.get());  // ③
        // 强制垃圾回收，执行垃圾回收后，GC会讲wr弱引用指向的对象回收，因此wr.get() = null;
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());  // ④
    }
}

