package com.renwei.io.firstsocket.mywx;

import java.io.*;
import java.net.Socket;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/21 0021
 */
public class MyClient01 {
    private final static Integer port = 8080;
    private final static String host = "192.168.1.95";


    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = new Socket(host, port);
            //客户端输入
            System.out.print("客户端:");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            // 向客户端回复信息
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(str);

            //服务端输出客户端的输入
            InputStream inputStream = socket.getInputStream();//获取字节流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//转换成字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//转换成缓冲流
            String s1 = bufferedReader.readLine();
            System.out.println("服务端:" + s1);

            //退出
            if (s1.equals("exit")) {
                break;
            }
        }
    }
}
