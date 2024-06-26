package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.08. 19:11
 * 引用类型的参数传递
 */
public class Code_P263 {

    public static void swap(DataWrap dataWrap) {
        int temp = dataWrap.a;
        dataWrap.a = dataWrap.b;
        dataWrap.b = temp;
        System.out.println("swap方法中a = " + dataWrap.a + ",b = " + dataWrap.b);
    }
    public static void main(String[] args) {
        DataWrap dataWrap = new DataWrap();
        dataWrap.a = 6;
        dataWrap.b = 9;
        swap(dataWrap);
        System.out.println("交换结束后，a =" + dataWrap.a + "b = " + dataWrap.b);
    }
}
class DataWrap{
    int a;
    int b;
}