package com.youn.have.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServerHandler> {
    public void completed(AsynchronousSocketChannel channel, AioServerHandler serverHandler) {
        //继续接受其他客户端的请求
        AioServer.clientCount++;
        System.out.println("连接的客户端数：" + AioServer.clientCount);
        serverHandler.channel.accept(serverHandler, this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer, buffer, new AioReadHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AioServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
