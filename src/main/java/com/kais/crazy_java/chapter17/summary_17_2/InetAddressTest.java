package com.kais.crazy_java.chapter17.summary_17_2;

import java.net.InetAddress;

/**
 * @author kais
 * @date 2022.08.26. 10:49
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        // 根据主机名来获取对应的InetAddress实例
        InetAddress ip = InetAddress.getByName("103.235.46.40");
        // 判断是否可达
        System.out.println("百度是否可达：" + ip.isReachable(2000));
        // 获取该InetAddress实例的IP字符串
        System.out.println("百度IP地址为：" + ip.getHostAddress());
        System.out.println("百度全限定域名：" + ip.getCanonicalHostName());
        System.out.println("百度主机名：" + ip.getHostName());

        System.out.println("-----------");

        // 根据原始IP地址来获取对应的InetAddress实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("本机是否可达：" + local.isReachable(2000));
        // 获取该InetAddress实例对应的全限定域名
        System.out.println("127, 0, 0, 1对应的主机名为：" + local.getCanonicalHostName());


        System.out.println("-------------");
/*        // 根据原始IP地址来获取对应的InetAddress实例
        InetAddress anotherLocal = InetAddress.getByAddress(new byte[]{(byte) 192, (byte) 168, 1, 71});
        System.out.println("目标主机是否可达：" + anotherLocal.isReachable(2000));
        // 获取该InetAddress实例对应的全限定域名
        System.out.println("对应的主机名为：" + anotherLocal.getCanonicalHostName());*/
    }
}