package com.kais.crazy_java.chapter05;

import lombok.var;

/**
 * @author kais
 * @date 2022.07.03. 02:50
 */
public class Code_P257 {

    public int age;
    public Code_P257 grow (){
        age ++;
        return this;
    }

    public static void main(String[] args) {

        var code_p257 = new Code_P257();
        code_p257.grow().grow().grow();
        System.out.println(code_p257.age);

    }


}
