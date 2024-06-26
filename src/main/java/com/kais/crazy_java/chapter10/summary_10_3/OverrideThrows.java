package com.kais.crazy_java.chapter10.summary_10_3;

import lombok.var;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.22. 15:13
 */
public class OverrideThrows {
    public void test() throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}

class Sub extends OverrideThrows {
    // 子类方法声明抛出了比父类方法更大的异常
    // 所以下面方法出错
//    @Override
//    public void test() throws Exception {
//    }
}


