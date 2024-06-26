package com.kais.crazy_java.chapter09.summary_9_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.22. 09:55
 */
public class TestClass {

    public static void main(String[] args) {

        ArrayList<String> objects = new ArrayList<>();
        ArrayList<Integer> objects1 = new ArrayList<>();
        System.out.println(objects.getClass() == objects1.getClass());

        ArrayList<Cat> objects3 = new ArrayList<>();
        ArrayList<Dog> objects4 = new ArrayList<>();
        System.out.println(objects3.getClass() == objects4.getClass());

    }

    public void test(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
