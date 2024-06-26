package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.04. 17:48
 */
public class Apple {

    public String name;

    public String color;

    public double weight;

    public Apple() {
    }

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /*
     * 三个参数的构造器
     */
    public Apple(String name, String color, double weight) {
        // 痛殴this调用另一个重载的构造器的初始化代码
        this(name,color);
        System.out.println("this = " + this);
        // this引用该构造器正在初始化的Java对象
        this.weight = weight;
    }
}
