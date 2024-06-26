package com.kais.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author kais
 * @date 2024.06.26. 15:08
 * stream的获取
 */
public class Stream01_GetStream {

    public static void main(String[] args) {

        //方式1：根据Collection获取流
        //Collection接口中有一个默认的方法:default Stream<E> stream()
        //1.List获取流
        List<String> list = new ArrayList<>();
        Stream<String> stream01 = list.stream();

        //2.Set获取流
        Set<String> set = new HashSet<>();
        Stream<String> stream02 = set.stream();

        //3.Map获取流
        //Map 并没有继承自 Collection 接口,所有无法通过该 map.stream()获取流。但是可用通过如下三种方式获取:
        Map<String, String> map = new HashMap<>();
        Stream<String> stream03 = map.keySet().stream();
        Stream<String> stream04 = map.values().stream();
        Stream<Map.Entry<String, String>> stream05 = map.entrySet().stream();

        //方式2：Stream中的静态方法of获取流
        // static<T> Stream<T> of(T... values)
        // T... values:可变参数，实际原理就是可变数组(传递String数组进去)

        //1.字符串获取流
        Stream<String> stream06 = Stream.of("aa", "bb", "cc");

        //2.数组类型(基本类型除外)
        String[] strs = {"aa", "bb", "cc"};
        Stream<String> stream07 = Stream.of(strs);

        //3.基本数据类型的数组
        int[] arr = {1, 2, 3, 4};
        //看着没报错，但是看到返回值是 int[],这是 Stream流把整个数组看做一个元素来操作，而不是操作数组中的int元素(这样子是不行的!!!)
        Stream<int[]> stream08 = Stream.of(arr);

    }
}
