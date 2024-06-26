package com.kais.crazy_java.chapter10.summary_10_2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.22. 14:27
 */
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
            // return语句强制方法返回
            System.out.println("即将执行catch中的return");
            return;       // ①
            // 使用exit来退出虚拟机
            // System.exit(1);     // ②
        } finally {
            // 关闭磁盘文件，回收资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    System.out.println("关闭磁盘资源异常！");
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行finally块里的资源回收!");
        }
    }
}
