package com.kais.crazy_java.chapter17.summary_17_3;

import lombok.var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author kais
 * @date 2022.08.26. 16:19
 */
public class Client {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("127.0.0.1", 30000);
        socket.setSoTimeout(10000);
        // 将Socket对应的输入流包装成BufferedReader（获取从服务器发送过来的数据）
        var br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try{
//            socket.connect(new InetSocketAddress("127.0.0.1", 30000),100);
            // 进行普通IO操作
            String line = br.readLine();
            System.out.println("来自服务器的数据：" + line);
        }catch (Exception e){
            // 关闭输入流、socket
            System.out.println(e.getMessage());
            br.close();
            socket.close();
        }

    }
}
