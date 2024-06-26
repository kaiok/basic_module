package com.kais.crazy_java.chapter14.summary_14_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 使@Retention指定注解的保留到运行时
@Retention(RetentionPolicy.RUNTIME)
// 使用@Target指定被修饰的注解可用于修饰方法
@Target(ElementType.METHOD)
// 定义一个标记注解，不包含任何成员变量，即不可传入元数据
public @interface Testable {
}
