package com.renwei.io.firstsocket.mywx;

import com.renwei.io.firstsocket.wx.Server;

import java.io.*;
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
public class MyServer {
    private final static Integer port = 8080;

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            //从队列中去获取一个连接 阻塞
            System.out.println("............1........");
            Socket accept = serverSocket.accept();
            System.out.println("............2........");
            //服务端输出客户端的输入
            InputStream inputStream = accept.getInputStream();//获取字节流
            Thread.sleep(10000);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//转换成字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//转换成缓冲流
            String s1 = bufferedReader.readLine();
            System.out.println("客户端:" + s1);


            //服务端输入
            System.out.print("服务端:");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            // 向客户端回复信息
            PrintStream out = new PrintStream(accept.getOutputStream());
            out.println(str);

            //  退出
            if (str.equals("exit")) {
                break;
            }
        }
    }
}
