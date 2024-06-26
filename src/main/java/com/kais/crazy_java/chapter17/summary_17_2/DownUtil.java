package com.kais.crazy_java.chapter17.summary_17_2;

import lombok.var;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author kais
 * @date 2022.08.26. 11:15
 * URLConnection:应用程序和URL之间的通讯连接
 * HttpURLConnection:应用程序与URL之间的HTTP连接
 */
public class DownUtil {

    // 定义下载资源的路径
    private String path;
    // 指定所下载的文件的保存位置
    private String targetFile;
    // 定义需要使用多少线程下载资源
    private int threadNum;
    // 定义下载的线程对象
    private DownThread[] threads;
    // 定义下载的文件的总大小
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.threadNum = threadNum;
        // 初始化threads数组，DownThread线程类，负责读取startPos开始，长度为currentPartSize的所有字节数据，并写入RandomAccessFile对象
        threads = new DownThread[threadNum];
        this.targetFile = targetFile;
    }

    public void download() throws Exception {
        // 获取URL对象
        var url = new URL(path);

        System.out.println("URL资源名：" + url.getFile());// URL资源名：/ch1/smoking01.jpg
        System.out.println("URL主机名：" + url.getHost());// URL主机名：localhost
        System.out.println("URL路径部分：" + url.getPath());// URL路径部分：/ch1/smoking01.jpg
        System.out.println("URL端口号：" + url.getPort());// URL端口号：8080
        System.out.println("URL协议：" + url.getProtocol());// URL协议：http
        System.out.println("URL查询字符串部分：" + url.getQuery());// URL查询字符串部分：null
        System.out.println("目标主机IP：" + url.getAuthority());// 目标主机IP：localhost:8080

        // 返回一个URLConnection对象，代表了与URL所引用的远程对象的连接
        var conn = (HttpURLConnection) url.openConnection();
        // 设置相关参数
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty(
                "Accept",
                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                        + "application/x-shockwave-flash, application/xaml+xml, "
                        + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                        + "application/x-ms-application, application/vnd.ms-excel, "
                        + "application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");

        // 得到指定URL对象所指向资源的大小
        fileSize = conn.getContentLength();
        System.out.println("该图片资源大小为：" + fileSize);
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        System.out.println("每个线程负责下载的资源大小为：" + currentPartSize);
        var file = new RandomAccessFile(targetFile, "rw");
        // 设置本地文件的大小
        file.setLength(fileSize);
        file.close();
        for (var i = 0; i < threadNum; i++) {
            // 计算每条线程的下载的开始位置
            var startPos = i * currentPartSize;
            // 每个线程使用一个RandomAccessFile进行下载
            var currentPart = new RandomAccessFile(targetFile, "rw");
            // 定位该线程的下载位置
            currentPart.seek(startPos);
            // 创建下载线程
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            // 启动下载线程
            threads[i].start();
        }
    }
    // 获取下载的完成百分比
    public double getCompleteRate() {
        // 统计多条线程已经下载的总大小
        var sumSize = 0;
        for (var i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        // 返回已经完成的百分比
        return sumSize * 1.0 / fileSize;
    }

    private class DownThread extends Thread {
        // 当前线程的下载位置
        private int startPos;
        // 定义当前线程负责下载的文件大小
        private int currentPartSize;
        // 当前线程需要下载的文件块
        private RandomAccessFile currentPart;
        // 定义已经该线程已下载的字节数
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }
        @Override
        public void run() {
            try {
                var url = new URL(path);
                var conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty(
                        "Accept",
                        "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                                + "application/x-shockwave-flash, application/xaml+xml, "
                                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                                + "application/x-ms-application, application/vnd.ms-excel, "
                                + "application/vnd.ms-powerpoint, application/msword, */*");
                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = conn.getInputStream();
                // 跳过startPos个字节，表明该线程只下载自己负责哪部分文件。
                inStream.skip(this.startPos);
                var buffer = new byte[1024];
                var hasRead = 0;
                // 读取网络数据，并写入本地文件
                while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    // 累计该线程下载的总大小
                    length += hasRead;
                }
                currentPart.close();
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
