package com.youn.have.io.nio;

public class NioServer {
    private static int DEFAULT_PORT = 12345;
    private static NioServerHandler serverHandle;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            serverHandle.stop();
        serverHandle = new NioServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        start();
    }
}
