package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.05. 16:21
 * 多态
 * Java引用变量有两个类型：一个是编译时类型，一个是运行时类型。
 * 编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。
 */
public class Code_P327 extends BaseClass{

    // 子类中重新定义一个book实例变量，隐藏父类的book实例变量
    public String book = "疯狂Java";

    public void test(){
        System.out.println("子类覆盖父类的方法");
    }

    public void sub(){
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {

        // 编译时类型与运行时类型一致，不存在多态
        BaseClass baseClass = new BaseClass();
        System.out.println(baseClass.book);
        baseClass.base();
        baseClass.test();

        // 编译时类型与运行时类型一致，不存在多态
        Code_P327 code_p327 = new Code_P327();
        System.out.println(code_p327.book);
        // 从父类继承到的base（）方法
        code_p327.base();
        // 调用将执行当前类的test方法
        code_p327.test();
        System.out.println("-----------------");
        // 编译时与运行时类型不一致，多态发生
        // 编译时类型：BaseClass，运行时类型：Code_P327
        // 编译看左运行看右，从左往右，先编译后运行
        BaseClass ploymophicBc = new Code_P327();
        // 父类的实例变量
        System.out.println(ploymophicBc.book);
        // 执行父类继承的base方法
        ploymophicBc.base();
        // 当前类的test方法，子类中的test方法覆盖了BaseClass中的test方法
        // 实际执行的是子类中的test方法，发生多态
        ploymophicBc.test();
        System.out.println("-----------------");
        // BaseClass类没有提供sub方法，而ploymophicBc编译时类型是BaseClass，所以下面代码会报错
//        ploymophicBc.sub();

    }
}
