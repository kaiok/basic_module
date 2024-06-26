package com.kais.crazy_java.chapter17.summary_17_3.Senior;

/**
 * @author kais
 * @date 2022.08.27. 22:06
 */
public interface CrazyItProtocol {
    // 定义协议字符串的长度
    int PROTOCOL_LEN = 2;
    // 下面是一些协议字符串，服务器和客户端交换的信息都应该在前、后添加这种特殊字符串。
    String MSG_ROUND = "§γ";
    String USER_ROUND = "&&";
    // 登录成功
    String LOGIN_SUCCESS = "1";
    // 用户名重复
    String NAME_REP = "-1";
    // 私聊信息
    String PRIVATE_ROUND = "@@";
    // 以SPLIT_SIGN分割字符串，前半是私聊用户，后半是聊天信息
    String SPLIT_SIGN = "※";
}
