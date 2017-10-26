package com.youn.have.io.aio;

public class AioServer {
    public volatile static long clientCount = 0;
    private static int DEFAULT_PORT = 12345;
    private static AioServerHandler serverHandle;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            return;
        serverHandle = new AioServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        AioServer.start();
    }
}
