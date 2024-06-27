package com.kais.stream.Stream04_Use;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kais
 * @date 2024.06.27. 14:33
 * Stream之聚合操作：
 */
public class AggregationOperationOfStream {

    public static void main(String[] args) {

        // 切记Stream流只能被消费一次,流就失效了，如下只是示例代码(报错：stream has already been operated upon or closed)
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );
        // 使用List集合创建Stream流
        ArrayList<Student> objects = new ArrayList<>();
        objects.add(new Student("赵丽颖", 58, 95));
        objects.add(new Student("杨颖", 56, 88));
        objects.add(new Student("迪丽热巴", 56, 99));
        objects.add(new Student("柳岩", 52, 77));

        //聚合操作
        //获取最大值(Stream流 max()方法亦可)
        //max()方法实现
        //Optional<Student> max = studentStream.max((s1, s2) -> s1.getScore() - s2.getScore());
        //(聚合)实现
        Optional<Student> max = objects.stream().collect(Collectors.maxBy((s1, s2) -> s1.getScore() - s2.getScore()));
        System.out.println("最大值:"+max.get());

        //获取最小值(Stream流 min()方法亦可)
        //min()方法实现
        //Optional<Student> min = studentStream.max((s1, s2) -> s2.getScore() - s1.getScore());
        //(聚合)实现
        Optional<Student> min = objects.stream().min(Comparator.comparingInt(Student::getScore));
        System.out.println("最小值:"+min.get());

        //求总和(使用Stream流的map()和reduce()方法亦可求和)
        //map()和reduce()方法实现
        //Integer reduce = studentStream.map(s -> s.getAge()).reduce(0, Integer::sum);
        //(聚合)简化前
        //Integer ageSum = studentStream.collect(Collectors.summingInt(s->s.getAge()));
        //(聚合)使用方法引用简化
        Integer ageSum = objects.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("年龄总和:"+ageSum);

        //求平均值
        //(聚合)简化前
        //Double avgScore = studentStream.collect(Collectors.averagingInt(s->s.getScore()));
        //(聚合)使用方法引用简化
        Double avgScore = objects.stream().collect(Collectors.averagingInt(Student::getScore));
        System.out.println("分数平均值:"+avgScore);

        //统计数量(Stream流 count()方法亦可)
        //count()方法实现
        //long count = studentStream.count();
        //(聚合)统计数量
        Long count = objects.stream().collect(Collectors.counting());
        System.out.println("数量为:"+count);
    }

}
