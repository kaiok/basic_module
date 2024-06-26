package com.kais.crazy_java.chapter08.summary_8_3;

import lombok.var;

import java.util.TreeSet;

/**
 * @author kais
 * @date 2022.08.19. 15:33
 * 添加两个相同的对象，equals返回false，但是compareTo返回0（即两个对象相等）
 */
class X implements Comparable {
    int count;

    public X(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "X[count:" + count + "]";
    }

    // 重写equals方法，根据count来判断是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == X.class) {
            var r = (X) obj;
            return r.count == this.count;
        }
        return false;
    }

    // 重写compareTo方法，根据count来比较大小
    @Override
    public int compareTo(Object obj) {
        var r = (X) obj;
        return count > r.count ? 1 :
                count < r.count ? -1 : 0;
    }
}

public class TreeSetTest3 {
    public static void main(String[] args) {
        var ts = new TreeSet();
        ts.add(new X(5));
        ts.add(new X(-3));
        ts.add(new X(9));
        ts.add(new X(-2));
        // 打印TreeSet集合，集合元素是有序排列的
        System.out.println(ts);    // ①
        // 取出第一个元素
        var first = (X) ts.first();
        // 对第一个元素的count赋值
        first.count = 20;
        // 取出最后一个元素
        var last = (X) ts.last();
        // 对最后一个元素的count赋值，与第二个元素的count相同
        last.count = -2;
        // 再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
        System.out.println(ts);   // ②
        // 删除实例变量被改变的元素，删除失败
        System.out.println(ts.remove(new X(-2)));   // ③
        System.out.println(ts);
        // 删除实例变量没有被改变的元素，删除成功
        System.out.println(ts.remove(new X(5)));    // ④
        System.out.println(ts);
    }
}
