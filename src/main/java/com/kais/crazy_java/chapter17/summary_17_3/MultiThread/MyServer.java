package com.kais.crazy_java.chapter17.summary_17_3.MultiThread;

import lombok.var;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.26. 17:05
 */
public class MyServer {

    // 定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws IOException {
        var ss = new ServerSocket(30000);
        while (true) {
            // 此行代码会阻塞，将一直等待别人的连接
            Socket s = ss.accept();
            socketList.add(s);
            // 每当客户端连接后启动一条ServerThread线程为该客户端服务，创建对每个用户的输入流，获取用户传输的数据
            new Thread(new ServerThread(s)).start();
        }
    }
}
