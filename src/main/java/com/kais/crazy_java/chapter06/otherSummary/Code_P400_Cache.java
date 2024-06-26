package com.kais.crazy_java.chapter06.otherSummary;

import lombok.var;

/**
 * @author kais
 * @date 2022.07.18. 10:53
 * 使用数组实现缓存效果
 * 1.构造方法私有，只能通过CacheImitate类中的valueOf方法获取实例
 */

class CacheImitate{
    private static int MAX_SIZE = 10;
    //使用数组缓存已有的实例
    private static CacheImitate[] cache =  new CacheImitate[MAX_SIZE];
    // 记录缓存实例在缓存中的位置cache[pos - 1]是最新缓存的实例
    private static int pos = 0;
    private final String name;

    private CacheImitate(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public static CacheImitate valueOf(String name){
        //遍历已缓存的对象
        for (int i = 0; i < MAX_SIZE; i++) {
            //如果已有相同实例，则直接返回该缓存的实例
            if(cache[i] != null && cache[i].getName().equals(name)){

                System.out.println("该数组元素值为：" + cache[i]);
                return cache[i];

            }
        }
        // 当数组中不存在该实例时
        if(pos == MAX_SIZE){
            // 把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始的位置
            cache[0] = new CacheImitate(name);
            // 把pos设置为1
            pos = 1;
        }else {
            // 把新创建的对象缓存起来，pos加1
            cache[pos ++] = new CacheImitate(name);
        }
        return cache[pos - 1];
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj != null && obj.getClass() == CacheImitate.class){
            var ci = (CacheImitate)obj;
            return name.equals(ci.getName());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }


}
public class Code_P400_Cache {

    public static void main(String[] args) {

        var c1 = CacheImitate.valueOf("hello");
        var c2 = CacheImitate.valueOf("hello");
        System.out.println(c1 == c2);
    }
}

