package com.kais.crazy_java.chapter06.summary_6_10;

/**
 * @author kais
 * @date 2022.08.18. 10:21
 */
public class FinalizeTest {
    private static FinalizeTest ft = null;

    public void info() {
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) throws Exception {
        // 创建FinalizeTest匿名对象，因为没有将该对象赋值给任何引用变量，所以该匿名对象
        // 会立即进入可恢复状态
        new FinalizeTest();
        /*
         * 1.通知系统进行资源回收
         * 注释该行代码，那么程序并没有通知系统开始执行垃圾回收，因此系统通常不会立即进行
         * 垃圾回收，也就不会调用FinalizeTest对象的finalize()方法，这就使得ft类变量继续保持
         * null，导致空指针异常
         * 2.②/③用于强制GC强制执行对象的finalize()方法，因此如果不执行该语句，同样无法确定
         * 系统何时调用对象的finalize()方法，ft对象同样可能为null
         */
        System.gc();  // ①
        // 强制垃圾回收机制调用可恢复对象的finalize()方法
//		Runtime.getRuntime().runFinalization();   // ②
        System.runFinalization();   // ③
        ft.info();
    }

    public void finalize() {
        // 让ft引用到试图回收的可恢复对象，即可恢复对象重新变成可达
        ft = this;
    }
}