package com.renwei.module_nio.SocketChannel;

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
        socketChannel.configureBlocking(false);
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
        //上面的操作是在往缓冲区写入数据
        //下面的操作是在从缓冲区拿取数据
        //所以要将缓冲区翻转一下
        byteBuffer.flip();
        //将缓冲区的流写入流
        socketChannel.write(byteBuffer);

        //从服务端接受数据
        byteBuffer.clear();
        //byteBuffer.flip();
        //此方法是阻塞的
        socketChannel.read(byteBuffer);
        System.out.println("客户端拿到的数据：" + new String(byteBuffer.array()));

    }
}
