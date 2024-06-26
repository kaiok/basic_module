package com.kais.crazy_java.chapter06.summary_6_7;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.10. 17:15
 * 匿名内部类的使用
 * test方法的参数为一个接口类型的对象，如果系统没有实现该接口的类，则可以考虑使用匿名内部类作为参数
 */
interface Product {
    double getPrice();

    String getName();
}
public class AnonymousTest {

    public void test(Product p) {

        System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());

    }

    public static void main(String[] args) {
        var ta = new AnonymousTest();
        // 调用test()方法时，需要传入一个Product参数，
        // 此处传入其匿名实现类的实例
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }
            @Override
            public String getName() {
                return "AGP显卡";
            }
        });
    }
}