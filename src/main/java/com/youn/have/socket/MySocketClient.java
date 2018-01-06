package com.youn.have.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author：YangJx
 * @Description：
 * @DateTime：2017/12/27 10:31
 */
public class MySocketClient {

    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1", 8421);
            System.out.println("客户端启动成功！");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter write = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readline;
            readline = br.readLine();
            while (!readline.equals("end")) {
                write.println(readline);
                write.flush();
                System.out.println("Client:" + readline);
                System.out.println("Server:" + in.readLine());
                readline = br.readLine();
            }
            write.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);
        }
    }
}