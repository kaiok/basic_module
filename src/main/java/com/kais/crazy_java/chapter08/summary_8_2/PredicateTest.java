package com.kais.crazy_java.chapter08.summary_8_2;

import lombok.var;

import java.util.HashSet;

/**
 * @author kais
 * @date 2022.08.19. 14:08
 * 使用removeIf删除集合中字符串元素长度小于10的元素
 */
public class PredicateTest {
    public static void main(String[] args) {
        // 创建一个集合
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
        // 使用Lambda表达式（目标类型是Predicate）过滤集合
        books.removeIf(ele -> ((String) ele).length() < 10);
        System.out.println(books);
    }
}