package com.kais.crazy_java.chapter17.summary_17_3.Senior;

import lombok.var;

import java.util.*;

/**
 * @author kais
 * @date 2022.08.27. 22:10
 * 组合一个HashMap数据结构，用于保存用户名和对应输出流之间的映射关系
 * 要求value值不能重复
 */
public class CrazyMap<K,V> {

    // 创建一个线程安全的HashMap
    public Map<K,V> map = Collections.synchronizedMap(new HashMap<K,V>());

    // 根据Map中的value来删除指定项
    public synchronized void removeByValue(Object value){
        // map.keySet(),返回Map中所有key,Set<K> ks = map.keySet();
        Set<K> ks = map.keySet();
        for (var key : map.keySet()) {
            if(map.get(key).equals(value) || map.get(key) == value){
                map.remove(key);
                break;
            }
        }
    }

    // 获取所有value组成的Set集合
    public synchronized Set<V> valueSet() {
        Set<V> result = new HashSet<>();
        // 将map中所有value添加到result集合中
        map.forEach((key, value) -> result.add(value));
        return result;
    }
    
    // 根据value查找key
    public synchronized K getKeyByValue(V val){
        // 遍历所有Key组成的集合
        for (var key : map.keySet()) {
            if(map.get(key) == val || map.get(key).equals(val)){
                return key;
            }
        }
        return null;
    }
    
    // HashMap的put方法，不允许value重复
    public synchronized V put(K key,V value){
        // 遍历所有value组成的集合
        for (var val : valueSet()) {
            // 如果某个value与试图放入Map中的value相同，则抛出一个RuntimeException异常
            if(val.equals(value) && val.hashCode() == value.hashCode()){
                throw new RuntimeException("Map实例中不允许有重复的value!");
            }
        }
        // Map里的put方法,如果key值不存在,则返回值是null,但是key值如果存在,则会返回原先被替换掉的value值
        return map.put(key,value);
    }


}
