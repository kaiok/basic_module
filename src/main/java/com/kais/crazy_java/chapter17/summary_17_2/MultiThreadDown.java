package com.kais.crazy_java.chapter17.summary_17_2;

import lombok.var;

/**
 * @author kais
 * @date 2022.08.26. 11:28
 * 需启动本地tomcat服务，将tomcat/ch1下的smoking01.jpg下载到该包下
 */
public class MultiThreadDown {
    public static void main(String[] args) throws Exception {
        // 初始化DownUtil对象
        final var downUtil = new DownUtil("http://localhost:8080/ch1/smoking01.jpg",
                "/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java/chapter17/summary_17_2/ios.jpg", 4);
        // 开始下载
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                // 每隔0.1秒查询一次任务的完成进度，
                System.out.println("已完成：" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {
                }
            }
        }).start();
    }
}