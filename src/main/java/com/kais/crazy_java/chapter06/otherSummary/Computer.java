package com.kais.crazy_java.chapter06.otherSummary;

/**
 * @author kais
 * @date 2022.08.10. 14:41
 *
 * 简单工厂模式的使用
 *
 * 1.当我们有一个Computer类需要组合一个输出设备时，我们推荐组合Output接口，而不是Printer类
 * 2.如果我们组合了Printer类，当系统中多处类组合了该类，而在未来，需要对Printer类进行重构时，那么我们就必须对所有组合了Printer的类进行修改了
 *      （比如方法参数的变化，等等）
 * 3.此处我们使用Computer类组合Output接口，我们可以再提供一个Output工厂，负责生成output对象，OutputFactory
 * 4.Computer类只需和Output接口进行耦合，即可实现Computer类与任何实现了Output接口的类进行组合
 */
public class Computer {

    private Output output;

    public Computer(Output out) {
        this.output = out;
    }

    // 定义一个模拟获取字符串输入的方法
    public void keyIn(String msg) {
        output.getData(msg);
    }

    // 定义一个模拟打印的方法
    public void print() {
        output.out();
    }

}
