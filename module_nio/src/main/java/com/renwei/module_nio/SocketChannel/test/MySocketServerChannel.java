package com.renwei.module_nio.SocketChannel.test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/28 0028
 */
public class MySocketServerChannel {
    public static void main(String[] args) throws Exception {
        //发布一个服务
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));//检测8080端口
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            if (accept == null) {
                Thread.sleep(10000);
                System.out.println("暂时没有连接进来.......");
            } else {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                accept.read(byteBuffer);
                System.out.println(new String(byteBuffer.array()) + serverSocketChannel.toString());
            }
        }
    }
}
