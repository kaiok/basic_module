package com.kais.crazy_java.chapter08.summary_8_2;

import lombok.var;

import java.util.HashSet;

/**
 * @author kais
 * @date 2022.08.19. 14:05
 */
public class ForeachTest {
    public static void main(String[] args) {
        // 创建集合、添加元素的代码与前一个程序相同
        var books = new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂Android讲义"));

        for (var obj : books) {
            // 此处的book变量也不是集合元素本身，修改book变量的值，并不会改变集合中元素的值
            var book = (String) obj;
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                // 下面代码会引发ConcurrentModificationException异常
                books.remove(book);     // ①
            }
        }
        System.out.println(books);
    }
}
