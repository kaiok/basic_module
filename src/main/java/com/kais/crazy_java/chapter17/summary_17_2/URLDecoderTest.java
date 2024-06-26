package com.kais.crazy_java.chapter17.summary_17_2;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author kais
 * @date 2022.08.26. 10:59
 * GBK编码，一个汉字占两个字节。 UTF-8编码是变长编码，通常汉字占三个字节，扩展B区以后的汉字占四个字节。UTF-16 统一采用两个字节表示一个字符
 */
public class URLDecoderTest {
    public static void main(String[] args) throws Exception {
        // 将application/x-www-form-urlencoded字符串转换成普通字符串
        // 其中的字符串直接从图17.3所示窗口复制过来
        String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf-8");
        System.out.println("按UTF-8解密后的字符串为：" + keyWord);
        // 将普通字符串转换成
        // application/x-www-form-urlencoded字符串
        String urlStr = URLEncoder.encode("疯狂Android讲义", "GBK");
        System.out.println("加密后的字符串为：" + urlStr);
    }
}
