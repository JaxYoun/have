package com.youn.have.io.nio;

import java.util.Scanner;

public class NioTest {
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //运行服务器
        NioServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        NioClient.start();
        while (NioClient.sendMsg(new Scanner(System.in).nextLine())) ;
    }
}
