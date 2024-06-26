package com.kais.crazy_java.chapter17.summary_17_3.Senior;

import lombok.var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author kais
 * @date 2022.08.28. 13:40
 */
public class ServerThread extends Thread{

    private Socket socket;
    // 服务器输入流
    BufferedReader br = null;
    // 服务器输出流
    PrintStream ps = null;
    // 定义一个构造器，用于接收一个Socket来创建ServerThread线程
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    // 将读到的内容去掉前后的协议字符，恢复成真实数据
    private String getRealMsg(String line) {
        return line.substring(CrazyItProtocol.PROTOCOL_LEN, line.length() - CrazyItProtocol.PROTOCOL_LEN);
    }

    public void run(){
        try{
            // 获取该Socket对应的输入流，获取用户发送的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 获取该socket对应的输出流，向用户发送消息
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while((line = br.readLine()) != null){
                // 如果输入流中的信息包含CrazyItProtocol.USER_ROUND，则读取到的为用户登录的用户名
                if(line.startsWith(CrazyItProtocol.USER_ROUND) && line.endsWith(CrazyItProtocol.USER_ROUND)){
                    String userName = getRealMsg(line);
                    // 如果用户名重复
                    if(Server.clients.map.containsKey(userName)){
                        System.out.println("用户名重复！");
                        ps.println(CrazyItProtocol.NAME_REP);
                    }else{
                        System.out.println("用户登录成功！");
                        ps.println(CrazyItProtocol.LOGIN_SUCCESS);
                        // 将用户名与其对应的输入流（针对服务器来说），存入map集合
                        Server.clients.put(userName,ps);

                        System.out.println("-----------");
                        System.out.println("系统用户为：");
                        for (var k :
                                Server.clients.map.keySet()) {
                            System.out.println("用户名为：" + k);
                        }
                        System.out.println("-----------");
                    }
                }else if(line.startsWith(CrazyItProtocol.PRIVATE_ROUND) && line.endsWith(CrazyItProtocol.PRIVATE_ROUND)){
                    System.out.println("接收到的私聊信息为：" + line);
                    // 处理私聊信息，CrazyItProtocol.PRIVATE_ROUND
                    String userAndMsg = getRealMsg(line);
                    // 以SPLIT_SIGN分割字符串，前半是私聊用户，后半是聊天信息
                    String user = userAndMsg.split(CrazyItProtocol.SPLIT_SIGN)[0];
                    System.out.println("私聊用户为：" + user);
                    String msg = userAndMsg.split(CrazyItProtocol.SPLIT_SIGN)[1];
                    System.out.println("私聊内容为：" + msg);
                    Server.clients.map.get(user).println("a private message from:" + Server.clients.getKeyByValue(ps) + ",message:" + msg);
                }else {
                    // 公聊信息
                    // 得到公聊信息
                    String msg = getRealMsg(line);
                    System.out.println("公聊信息为：" + line);
                    for (var clientPs : Server.clients.valueSet()) {
                        clientPs.println(Server.clients.getKeyByValue(ps) + " say: " + msg);
                    }
                }
            }
        } catch (IOException e) {
            // 捕捉到异常后，表明该Socket对应的客户端已经出现了问题
            // 所以程序将其对应的输出流从Map中删除
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.map.size());
            // 关闭网络、IO资源
            try {
                if (br != null) {
                    br.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
