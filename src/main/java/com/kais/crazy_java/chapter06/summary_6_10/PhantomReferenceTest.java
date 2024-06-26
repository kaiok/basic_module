package com.kais.crazy_java.chapter06.summary_6_10;

import lombok.var;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author kais
 * @date 2022.08.18. 11:03
 */
public class PhantomReferenceTest {
    public static void main(String[] args) throws Exception {
        // 创建一个字符串对象
        var str = new String("疯狂Java讲义");
        // 创建一个引用队列
        var rq = new ReferenceQueue();
        // 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
        var pr = new PhantomReference(str, rq);
        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null
        System.out.println(pr.get());  // ①
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 垃圾回收之后，虚引用将被放入引用队列中
        // 取出引用队列中最先进入队列中的引用与pr进行比较
        System.out.println(rq.poll() == pr);   // ②
    }
}