package com.kais.crazy_java.chapter06.summary_6_10;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.17. 15:23
 * 当不执行强制系统进行垃圾回收的代码时，main方法执行结束，系统不会及时调用每个GcTest对象的
 *  finalize()方法，即没有任何输出--4个GcTest匿名对象此时处于不可达状态。因此，我们并不能确定
 *  垃圾回收机制何时会回收处于不可达状态的对象
 */
public class GcTest {
    public static void main(String[] args) {
        for (var i = 0; i < 4; i++) {
            new GcTest();
            // 下面两行代码的作用完全相同，强制系统进行垃圾回收
            // System.gc();
//            Runtime.getRuntime().gc();
        }
    }

    @Override
    public void finalize() {
        System.out.println("系统正在清理GcTest对象的资源...");
    }
}