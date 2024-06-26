package com.kais.crazy_java.chapter17.summary_17_3.Senior;

import lombok.var;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kais
 * @date 2022.08.28. 13:26
 * 私聊信息：@@用户名*发送的消息@@
 * 登录信息：&&用户名&&，不需要密码
 */
public class Server {

    private static final int SERVER_PORT = 30000;

    // 使用map集合存储用户姓名与该用户对应的输出流对象
    public static CrazyMap<String, PrintStream> clients = new CrazyMap<>();

    public void init(){
        try(
                var serverSocket = new ServerSocket(SERVER_PORT);
                ){
            while(true){
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        }catch (IOException e){
            System.out.println("服务器启动失败！");
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

}
