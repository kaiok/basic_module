package com.kais.stream;


import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kais
 * @date 2022.07.01. 15:33
 * Stream对Map集合的处理
 *
 *  map方法的接口方法声明如下，接受一个 Function函数式接口，把它翻译成映射最合适了，通过原始数据元素，映射出新的类型
 *  <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 *  Function中的R apply(T t);方法，接收T型参数，返回R型参数--->类型转换，当T、R类型一致，那么就和peek方法一致了
 *
 */
public class Stream03_Map {

    /**
     * 模拟的数据，User类
     */
    public static List<User> getUserData(){
        Random random = new Random();
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "kais", random.nextInt(100), "male", "1232323", "anywhere");
            userList.add(user);
        }
        return userList;
    }

    /**
     * User实体类转换为DTO类
     */
    private static UserDTO dao(User user){
        UserDTO userDTO = new UserDTO();
        try {
            BeanUtils.copyProperties(userDTO,user);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return userDTO;
    }

    /**
     * map
     * 将 User 转换为 API 输出的数据格式
     * Collectors.toList() 将流中的所有元素导出到一个列表( List )中
     */
    @Test
    public void test_map(){
        List<User> userData = getUserData();
        // 将List集合中的元素转换为stream
        Stream<User> stream = userData.stream();
        List<UserDTO> collect = stream.map(user -> dao(user)).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Collectors.toList()将数据收集进一个列表(Stream 转换为 List，允许重复值，有顺序)
     */
    @Test
    public void test_collectors_toList(){
        List<User> userData = getUserData();
        Stream<User> stream = userData.stream();
        List<User> collect = stream.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * <R, A> R collect(Collector<? super T, A, R> collector);
     * Integer Stream 过滤出大于 7 的值，然后转换成 List<Integer>集合，用的是 Collectors.toList()这个收集器
     */
    @Test
    public void test_collection(){
        Stream<Integer> integerStream = Stream.of(1,2,5,7,8,12,33);
        List<Integer> list = integerStream.filter(s -> s.intValue()>7).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * Collectors.toList()可查看toList源码
     */
    @Test
    public void test_collection_01(){
        Stream<Integer> integerStream = Stream.of(1,2,5,7,8,12,33);
        List<Integer> list = integerStream.filter(s -> s.intValue()>7).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

}
