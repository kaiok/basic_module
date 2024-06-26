package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.15. 15:48
 * 使用组合代替继承，实现类中方法的复用
 */
public class Code_P339_Combine {

    public static void main(String[] args) {
        // 显式的创建被组合的对象
        Animal1 animal1 = new Animal1();
        Bird bird = new Bird(animal1);
        bird.breathe();
        bird.fly();

        int a = 10;
        Integer integer = Integer.valueOf(a);

    }

}

class Animal1{
    private void beat(){
        System.out.println("心脏跳动....");
    }
    public void breathe(){
        beat();
        System.out.println("吸一口气，吐一口气...");
    }
}

class Bird{
    // 将原来的父类组合到原来的子类，作为子类的一个组合部分
    private Animal1 animal;
    public Bird(Animal1 animal){
        this.animal = animal;
    }
    // 重新定义一个自己的breath方法
    public void breathe(){
        // 直接复用Animal提供的breathe（）方法实现Bird的breathe（）方法
        animal.breathe();
    }
    public void fly(){
        System.out.println("我在天空自由飞翔.....");
    }
}