package com.renwei.module_nio.SocketChannel.test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/28 0028
 */
public class MySocketClientChannel {
    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        //注册一个连接
        socketChannel.connect(new InetSocketAddress("192.168.1.95", 8080));
        if (socketChannel.isConnectionPending()){
            socketChannel.finishConnect();
        }

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //往服务端发送数据
        //往缓冲区写入数据
        byteBuffer.put("Hello! i love you".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}
