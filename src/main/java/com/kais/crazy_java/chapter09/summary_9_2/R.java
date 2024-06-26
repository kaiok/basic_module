package com.kais.crazy_java.chapter09.summary_9_2;

/**
 * @author kais
 * @date 2022.08.22. 11:30
 */
public class R<T> {
    // 下面代码错误，不能在静态变量声明中使用泛型形参
//	static T info;

    T age;
    public void foo(T msg) {
    }

    // 下面代码错误，不能在静态方法声明中使用泛型形参
//	public static void bar(T msg){}

    public static void main(String[] args) {

        // 由于系统不会真正生成泛型类，所以instanceof运算符后不能使用泛型类
//        ArrayList<String> objects = new ArrayList<>();
//        if(objects instanceof List<String>){
//
//        }
    }
}


