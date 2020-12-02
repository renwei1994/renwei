package com.renwei.module_nio.SocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
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
        //serverSocketChannel.accept()原本是阻塞的方法，只有等到有链接的时候才不阻塞
        //
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));//检测8080端口
        while (true) {
            //循环获取链接  当为获取当连接此方法处于阻塞
            SocketChannel accept = serverSocketChannel.accept();
            if (accept == null) {
                Thread.sleep(1000);
                System.out.println("暂时没有连接进来.......");
            } else {
                //接受客户端发送的数据
                //创建缓冲区
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                //把连接中的流读入缓冲区
                accept.read(byteBuffer);
                System.out.println(new String(byteBuffer.array()));

                //往客户端发送数据
                //再把消息写回客户端
                //上面是消息写入缓冲区
                //下面是吧消息写出缓冲区
                byteBuffer.flip();
                accept.write(byteBuffer);
            }
        }
    }
}
