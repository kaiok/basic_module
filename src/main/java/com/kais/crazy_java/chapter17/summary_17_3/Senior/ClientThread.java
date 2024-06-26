package com.kais.crazy_java.chapter17.summary_17_3.Senior;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author kais
 * @date 2022.08.28. 14:03
 */
public class ClientThread extends Thread{

    // 客户端线程处理的输入流，接受服务器传输的信息
    BufferedReader br = null;
    // 客户端线程构造方法，每个客户端对应一个输入流
    public ClientThread(BufferedReader br){
        this.br = br;
    }
    @Override
    public void run(){
        try{
            String line = null;
            // 不断的从输入流中读取数据，并将这些数据打印输出
            while((line = br.readLine()) != null){
                System.out.println(line);
                /*
				扩展功能：服务器在每次有用户登录、用户退出时，将所有用户列表信息都向客户端发送一遍。
				为了区分服务器发送的是聊天信息，还是用户列表，服务器也应该在要发送的信息前、后都添加一定的协议字符串，客户端此处则根据协议
				字符串的不同而进行不同的处理！
				*/
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("异常信息为：" + e.getMessage());
        }finally {
            try{
                if(br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("关系IO资源异常");
            }
        }
    }

}
