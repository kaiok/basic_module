package com.kais.crazy_java.chapter06.otherSummary;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.10. 14:48
 * 1.将所有生成Output对象的逻辑集中在OutputFactory工厂类中管理
 * 2.所有需要使用Output对象的类与Output接口进行耦合（Computer）
 * 3.这种情况下，即使系统中有多个Printer对象，只要OutputFactory类中的getOutput方法生成的对象是该特定的Printer对象，则调用getOutput方法
 *      生成Output对象的类中，返回的Printer对象都会改变，此时仅需更改一处代码即可实现全部修改了
 */
public class OutputFactory {

    /**
     * 用于返回任何种类的输出对象，返回的对象实现了Output接口
     * @return
     */
    public Output getOutput() {
        // 决定返回Output实现类的对象
//		return new Printer();
        // 当后期对Printer进行重构为BetterPrint类时，我们只需要使BetterPrinter类实现Output接口即可，在此处返回该重构后的类的对象
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        var of = new OutputFactory();
        var c = new Computer(of.getOutput());
        c.keyIn("轻量级Java EE企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }

}
