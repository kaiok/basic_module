package com.kais.crazy_java.chapter17.summary_17_3.MultiThread;

import lombok.var;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author kais
 * @date 2022.08.26. 17:26
 */
public class MyClient {
    public static void main(String[] args) throws Exception {
        var s = new Socket("127.0.0.1", 30000);
        // 客户端启动ClientThread线程，创建输入流，不断读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        // 获取该Socket对应的输出流
        var ps = new PrintStream(s.getOutputStream());
        String line = null;
        // 不断读取键盘输入
        var br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            // 将用户的键盘输入内容写入Socket对应的输出流
            ps.println(line);
        }
    }
}
