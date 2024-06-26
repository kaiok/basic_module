package com.kais.crazy_java.chapter15.summary_15_8;

/**
 * @author kais
 * @date 2022.08.25. 03:19
 */
public class Person implements java.io.Serializable {
    private String name;
    private int age;
    // 注意此处没有提供无参数的构造器!
    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    // age的setter和getter方法
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
}