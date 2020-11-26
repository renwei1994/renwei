package com.renwei.io.firstsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/21 0021
 */
public class Client01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("192.168.1.95", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(("woshiainid2" ).getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
