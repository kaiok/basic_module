package com.kais.crazy_java.chapter14.summary_14_3.o1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kais
 * @date 2022.08.22. 17:37
 */
// 指定该注解信息会保留到运行时
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FkTags {
    // 定义value成员变量，该成员变量可接受多个@FkTag注解，即FkTags作为FkTag的容器
    FkTag[] value();
}