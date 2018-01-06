package com.youn.have.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：YangJx
 * @Description：socket服务器测试
 * @DateTime：2017/12/27 10:29
 */
public class MySocketServer {
    public static void main(String[] args) throws IOException {
        MySocketServer socketService = new MySocketServer();
        socketService.oneServer(8421);
    }

    public void oneServer(int port) {
        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(port);
                System.out.println("服务器启动成功");
            } catch (Exception e) {
                System.out.println("没有启动监听：" + e);
            }
            Socket socket = null;
            try {
                socket = server.accept();
            } catch (Exception e) {
                System.out.println("Error." + e);
            }
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:" + in.readLine());
            line = br.readLine();
            while (!line.equals("end")) {
                writer.println(line);
                writer.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + in.readLine());
                line = br.readLine();
            }

            writer.close();
            in.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            System.out.println("Error." + e);
        }
    }
}