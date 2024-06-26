package com.kais.crazy_java.chapter06.otherSummary;

/**
 * @author kais
 * @date 2022.07.16. 14:17
 * 来自疯狂Java中的单例模式
 */
public class Code_P380_Singleton {

    public static void main(String[] args) {

        // 创建Singleton对象不能通过构造器
        // 只能通过getInstance方法来得到该实例
        Singleton instance = Singleton.getInstance();
        // 第二次调用getInstance方法时，由于第一次调用已经创建了Singleton对象，由instance静态引用类变量指向该对象
        // 当第二次进行调用时，instance指向的Singleton对象为同一个，不为空，所以返回的还是同一个Singleton对象
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);

    }

}

class Singleton{

    // 3.使用类变量缓存曾经创建的实例，保证多次调用getInstance方法的instance是同一个
    // (使用private进行封装，只能在getInstance方法中调用该类对象)
    private static Singleton instance;
    // 1.对构造器使用private修饰，隐藏该构造器
    private Singleton(){}
    // 2.提供一个静态方法，用于返回Singleton实例；加入自定义控制，保证只有一个Singleton实例对象的创建
    // 保证该方法必须有
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        // 当instance != null 直接返回该instance，保证一个Singleton对象
        return instance;
    }

}
