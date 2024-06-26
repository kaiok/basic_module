package com.kais.crazy_java.chapter14.summary_14_3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.22. 17:51
 */
// 定义一个简单的类型注解，不带任何成员变量
@Target(ElementType.TYPE_USE)
@interface NotNull {

}
// 定义类时使用类型注解
@NotNull
public class TypeAnnotationTest implements @NotNull Serializable {
    // 方法形参中使用类型注解
    // throws时使用类型注解
    public static void main(@NotNull String[] args) throws @NotNull FileNotFoundException {

        Object obj = "fkjava.org";
        // 强制类型转换时使用类型注解
        String str = (@NotNull String) obj;
        // 创建对象时使用类型注解
        Object win = new @NotNull JFrame("疯狂软件");

    }

    // 泛型中使用类型注解
    public void foo(List<@NotNull String> info) {

    }
}
