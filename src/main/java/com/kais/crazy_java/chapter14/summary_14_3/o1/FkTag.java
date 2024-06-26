package com.kais.crazy_java.chapter14.summary_14_3.o1;

import java.lang.annotation.*;

/**
 * @author kais
 * @date 2022.08.22. 17:37
 * 重复注解的使用
 */
// 指定该注解信息会保留到运行时
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(FkTags.class)
public @interface FkTag {
    // 为该注解定义2个成员变量
    String name() default "疯狂软件";
    int age();
}