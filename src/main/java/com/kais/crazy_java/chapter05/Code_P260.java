package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.08. 18:50
 */
public class Code_P260 {
    public static void swap(int a ,int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap方法中a = " + a + ",b = " + b);
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        swap(a,b);
        System.out.println("交换结束后，a =" + a + "b = " + b);
    }
}
