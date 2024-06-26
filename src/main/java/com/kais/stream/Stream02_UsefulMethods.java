package com.kais.stream;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kais.stream.Stream03_Map.getUserData;


/**
 * @author kais
 * @date 2022.07.01. 14:55
 * Stream常用API的使用
 */
public class Stream02_UsefulMethods {

    /**
     * 可接收一个泛型对象或可变成泛型集合，构造一个 Stream 对象
     */
    @Test
    public void test_of(){
        Stream<String> stringStream = Stream.of("a", "b", "c");
        System.out.println(stringStream.toString());
    }

    /**
     * 连接两个Stream，不改变其中任何一个Stream对象，返回一个新的Stream对象
     */
    @Test
    public void test_concat(){
        Stream<String> a = Stream.of("a","b","c");
        Stream<String> b = Stream.of("d","e");
        Stream<String> c = Stream.concat(a,b);
    }

    /**
     * max方法
     * 一般用于求数字集合中的最大值，或者按实体中数字类型的属性比较，拥有最大值的那个实体。它接收一个 Comparator<T>，上面也举到这个例子了，
     * 它是一个函数式接口类型，专门用作定义两个对象之间的比较，例如下面这个方法使用了 Integer::compareTo这个方法引用
     */
    @Test
    public void test_max(){
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Integer max = integerStream.max(Integer::compareTo).get();
        System.out.println(max);
    }

    /**
     * 自定义Comparator
     */
    @Test
    public void test_PersonComparator(){
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Comparator<Integer> comparator =  (x, y) -> (x.intValue() < y.intValue()) ? -1 : ((x.equals(y)) ? 0 : 1);
        Integer max = integerStream.max(comparator).get();
        System.out.println(max);
    }


    /**
     * count 方法（终结流方法）
     */
    @Test
    public void test_count(){
        Stream<String> a = Stream.of("a", "b", "c");
        long x = a.count();
        System.out.println(x);
    }

    /**
     * peek
     * 1 建立一个通道，在这个通道中对 Stream 的每个元素执行对应的操作，对应 Consumer<T>的函数式接口，这是一个消费者函数式接口，顾名思义，
     * 它是用来消费 Stream 元素的，比如下面这个方法，把每个元素转换成对应的大写字母并输出
     * 2 peek是一个中间操作：中间操作是流水线中的数据进行加工的, 它是一个懒操作, 并不会马上执行, 需要等待有终止操作的时候才会执行
     * 3 peek的设计初衷就是在流的每个元素恢复运行之前的时候插入一个执行操作. 它不像forEach那样恢复整个流的运行操作.
     * 而是在一个元素上完成操作之后, 它只会将操作顺承到流水线的下一个操作. 它能够将中间变量的值输出到日志.
     * 有效的帮助我们了解流水线的每一步操作的输出值
     */
    @Test
    public void test_peek(){
        Stream<String> a = Stream.of("a", "b", "c");
        // 包含输出语句
        List<String> collect = a.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
        // 输出原字符
//        System.out.println(collect);
    }

    /**
     * forEach
     * 和 peek 方法类似，都接收一个消费者函数式接口，可以对每个元素进行对应的操作，但是和 peek 不同的是，forEach 执行之后，
     *      这个 Stream 就真的被消费掉了，之后这个 Stream 流就没有了，不可以再对它进行后续操作了，而 peek操作完之后，
     *      还是一个可操作的 Stream 对象
     * 正好借着这个说一下，我们在使用 Stream API 的时候，都是一串链式操作，这是因为很多方法，比如接下来要说到的 filter方法等，
     *      返回值还是这个 Stream 类型的，也就是被当前方法处理过的 Stream 对象，所以 Stream API 仍然可以使用
     */
    @Test
    public void test_forEach(){
        Stream<String> a = Stream.of("a", "b", "c");
        a.forEach(e->System.out.println(e.toUpperCase()));
    }

    /**
     * limit
     * 获取前 n 条数据，类似于 MySQL 的limit，只不过只能接收一个参数，就是数据条数
     */
    @Test
    public void test_limit(){
        Stream<String> a = Stream.of("a", "b", "c");
        a.limit(2).forEach(e->System.out.println(e));
    }

    /**
     * skip
     * 跳过前 n 条数据，例如下面代码，返回结果是 c。
     */
    @Test
    public void test_skip(){
        Stream<String> a = Stream.of("a", "b", "c");
        a.skip(2).forEach(e->System.out.println(e));
    }

    /**
     * distinct
     * 元素去重，例如下面方法返回元素是 a、b、c，将重复的 b 只保留了一个
     */
    @Test
    public void test_distinct(){
        Stream<String> a = Stream.of("a", "b", "c","b");
        a.distinct().forEach(e->System.out.println(e));
    }


    /**
     * filter
     * 用于条件筛选过滤，筛选出符合条件的数据。例如下面这个方法，筛选出性别为 0，年龄大于 50 的记录
     */
    @Test
    public void test_filter(){
        List<User> users = getUserData();
        Stream<User> stream = users.stream();
        stream.filter(user -> user.getGender().equals("male") && user.getAge()>50).forEach(e->System.out.println(e));
    }

}
