package com.kais.crazy_java.chapter17.summary_17_3.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author kais
 * @date 2022.08.28. 14:03
 */
public class Client {

    // 定义客户端Socket端口，连接服务器
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    // 客户端输入流
    private PrintStream ps;
    // 客户端输入流
    private BufferedReader brServer;
    // 键盘输入流
    private BufferedReader keyIn;

    public static void main(String[] args) {

        Client client = new Client();
        client.init();
        client.readAndSend();
    }

    public void init(){

        try{
            // 初始化键盘输入流
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            // 连接到服务器
            socket = new Socket("127.0.0.1",SERVER_PORT);
            // 获取该socket对应的输入流和输出流
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String tip = "";
            while (true){
                // 采用循环不断的弹出对话框要求输入用户名
                System.out.println("请输入用户名，格式为&&userName&&：");
                String userName = keyIn.readLine();
                // 将用户输入的用户名的前后增加协议字符串后发送，输出到服务器
                ps.println(userName);
                // 读取服务器的响应
                String result = brServer.readLine();
                // 如果用户重复，开始下次循环
                if(result.equals(CrazyItProtocol.NAME_REP)){
                    tip = "用户名重复！请重新登录";
                    System.out.println(tip);
                    continue;
                }
                // 登录成功
                if(result.equals(CrazyItProtocol.LOGIN_SUCCESS)){
                    break;
                }
            }

        }catch (UnknownHostException ex){
            System.out.println("找不到远程服务器！");
            closeRs();
        }catch (IOException exception){
            System.out.println("网络异常，请重新登录！");
            closeRs();
            System.exit(1);
        }
        // 以该Socket对应的输入流启动ClientThread线程
        new ClientThread(brServer).start();
    }

    // 关闭Socket、输入流、输出流
    private void closeRs(){
        try{
            if(keyIn != null){
                keyIn.close();
            }
            if(ps != null){
                ps.close();
            }
            if(socket != null){
                socket.close();
            }
            if(brServer != null){
                brServer.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 定义一个读取键盘输入、并向网络发送的方法
    private void readAndSend(){
        try{
            // 不断的读取键盘输入
            String line = null;
            while((line = keyIn.readLine()) != null){
                // 如果发送的信号中有@，则为私聊消息，格式为@User:content
                if(line.indexOf(":") > 0 && line.startsWith("@")){
                    line = line.substring(1);
                    String userName = line.split(":")[0];
                    String content = line.split(":")[1];
                    ps.println(CrazyItProtocol.PRIVATE_ROUND + line.split(":")[0] + CrazyItProtocol.SPLIT_SIGN +
                            line.split(":")[1] + CrazyItProtocol.PRIVATE_ROUND);
                }else{
                    ps.println(CrazyItProtocol.MSG_ROUND + line + CrazyItProtocol.MSG_ROUND);
                }
            }
        }catch (IOException e){
            System.out.println("网络通信异常！请重新登录！");
            closeRs();
            System.exit(1);
        }
    }

}
