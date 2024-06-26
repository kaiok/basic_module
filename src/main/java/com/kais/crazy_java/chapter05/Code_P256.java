package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.07. 11:47
 */
public class Code_P256 {

    // 定义一个名为num的成员变量
    public int num;

    public Code_P256() {
        //在构造器中定义一个num变量
        int num = 0;
        // 使用this代表该构造器正在初始化的对象
        // 下面的代码将会把该构造器正在初始化的对象的num成员变量设置为5
        this.num = 5;
    }

    public static void main(String[] args) {
        // 所有使用Code_P256创建的对象的num成员变量都将被设置为5
        System.out.println(new Code_P256().num);
    }
}
