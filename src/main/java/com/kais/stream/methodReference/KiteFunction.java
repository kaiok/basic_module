package com.kais.stream.methodReference;

/**
 * @author kais
 * @date 2022.07.01. 13:29
 * 自定义的函数式接口
 */
@FunctionalInterface
public interface KiteFunction<T,R,S> {

    /**
     * 定义一个双参数的方法
     */
    R run(T t,S s);

}
