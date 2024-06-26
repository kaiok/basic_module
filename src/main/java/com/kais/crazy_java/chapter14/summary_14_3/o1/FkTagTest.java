package com.kais.crazy_java.chapter14.summary_14_3.o1;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.22. 17:47
 */
@FkTag(age = 5)
@FkTag(name = "疯狂Java", age = 9)
//@FkTags({@FkTag(age = 5),@FkTag(name = "疯狂Java", age = 9)})
public class FkTagTest {
    public static void main(String[] args) {
        Class<FkTagTest> clazz = FkTagTest.class;
        //使用Java 8新增的getDeclaredAnnotationsByType()方法获取修饰FkTagTest类的多个@FkTag注解
        FkTag[] tags = clazz.getDeclaredAnnotationsByType(FkTag.class);
        // 遍历修饰FkTagTest类的多个@FkTag注解
        for (var tag : tags) {
            System.out.println(tag.name() + "-->" + tag.age());
        }
        //使用传统的getDeclaredAnnotation()方法获取修饰FkTagTest类的@FkTags注解
        FkTags container = clazz.getDeclaredAnnotation(FkTags.class);
        System.out.println(container);
    }
}
