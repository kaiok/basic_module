package com.kais.crazy_java.chapter05;

/**
 * @author kais
 * @date 2022.07.04. 10:19
 * 递归的简单使用
 * getValue(3) = 22
 * getValue(2) = 9
 * getValue(1) = 4
 */
public class Code_P269 {

    public static void main(String[] args) {

        System.out.println(getValue(1));

    }

    public static Integer getValue(Integer num){
        if(num.equals(0)){
            return 1;
        }else if(num.equals(1)){
            return 4;
        }else{
            return getValue(num - 1) * 2 + getValue(num - 2);
        }
    }

}
