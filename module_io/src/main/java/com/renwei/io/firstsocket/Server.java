package com.renwei.io.firstsocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/21 0021
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8080);
        //获取一个连接
        while (true) {
            System.out.println("...........1");
            Socket accept = serverSocket.accept();
            System.out.println("...........2");
            Thread.sleep(10000);
            //获取这个链接对应的流
            InputStream inputStream = accept.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len, "UTF-8"));
            }
        }
    }
}
