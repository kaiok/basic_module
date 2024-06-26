package com.kais.crazy_java.chapter08.summary_8_3;

import lombok.var;

import java.util.TreeSet;

/**
 * @author kais
 * @date 2022.08.19. 15:25
 * 存储两个相同的元素，equals方法返回true，compareTo返回1（不相等）的情况
 * 不正确的重写了compareTo方法，导致TreeSet存储了两个值相等的元素
 */
class Z implements Comparable {
    int age;

    public Z(int age) {
        this.age = age;
    }

    // 重写equals()方法，总是返回true
    public boolean equals(Object obj) {
        return true;
    }

    // 重写了compareTo(Object obj)方法，总是返回1
    public int compareTo(Object obj) {
        return 1;
    }
}

public class TreeSetTest2 {
    public static void main(String[] args) {
        var set = new TreeSet();
        var z1 = new Z(6);
        set.add(z1);

        // 第二次添加同一个对象，输出true，compareTo总是返回1，表明这两个元素不相等，添加成功
        System.out.println(set.add(z1));    // ①
        // 下面输出set集合，将看到有两个元素
        System.out.println(set);
        // 修改set集合的第一个元素的age变量
        ((Z) (set.first())).age = 9;
        // 输出set集合的最后一个元素的age变量，将看到也变成了9
        System.out.println(((Z) (set.last())).age);
    }
}

