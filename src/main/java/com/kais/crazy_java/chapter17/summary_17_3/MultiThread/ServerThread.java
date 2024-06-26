package com.kais.crazy_java.chapter17.summary_17_3.MultiThread;

import lombok.var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author kais
 * @date 2022.08.26. 17:06
 */
// 负责处理每个线程通信的线程类
public class ServerThread implements Runnable {
    // 定义当前线程所处理的Socket
    Socket s = null;
    // 该线程所处理的Socket所对应的输入流
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        // 初始化该Socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String content = null;
            // 采用循环不断从Socket中读取客户端发送过来的数据
            while ((content = readFromClient()) != null) {
                // 遍历socketList中的每个Socket，将读到的内容向每个Socket发送一次，广播给每一个Socket客户端
                for (var s : MyServer.socketList) {
                    if(s instanceof Socket){
                        System.out.println("正在向" + s.getInetAddress() + s.getPort() + "客户端发送消息");
                    }
                    var ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 定义读取客户端数据的方法
    private String readFromClient() {
        try {
            return br.readLine();
        }
        // 如果捕捉到异常，表明该Socket对应的客户端已经关闭
        catch (IOException e) {
            // 删除该Socket。
            MyServer.socketList.remove(s);
        }
        return null;
    }
}
