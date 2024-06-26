package com.kais.crazy_java.chapter06.summary_6_7;

/**
 * @author kais
 * @date 2022.08.10. 17:05
 * 外部类以外的地方调用静态内部类
 */
class StaticOut {
    // 定义一个静态内部类，不使用访问控制符，
    // 即同一个包中其他类可访问该内部类
    static class StaticIn {
        public StaticIn() {
            System.out.println("静态内部类的构造器");
        }
    }
}
public class CreateStaticInnerInstance {
    public static void main(String[] args) {
        StaticOut.StaticIn in = new StaticOut.StaticIn();
		/*
		上面代码可改为如下两行代码：
		使用OuterClass.InnerClass的形式定义内部类变量
		StaticOut.StaticIn in;
		通过new来调用内部类构造器创建静态内部类实例
		in = new StaticOut.StaticIn();
		*/
    }
}
