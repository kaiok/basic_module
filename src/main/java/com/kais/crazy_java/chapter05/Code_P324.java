package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.15. 15:18
 */
public class Code_P324 extends Animal{

    public Code_P324(){
        //显式调用父类有两个参数的构造器
        super("huitailang",3);
        System.out.println("主类无参构造器");
    }

    public static void main(String[] args) {
        new Code_P324();
    }

}
class Creature{
    public Creature(){
        System.out.println("Creature无参构造器");
    }
}

class Animal extends Creature{
    public Animal(String name){
        System.out.println("Animal带一个参数的构造器，" + "该动物的name为" + name);
    }
    public Animal(String name,int age){
        // 使用this调用同一个重载的构造器，即public Animal(String name)
        this(name);
        System.out.println("Animal带两个参数的构造器，name = " + name + "，age为" + age);
    }
}