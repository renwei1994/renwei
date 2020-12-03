package com.renwei.module_nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/2 0002
 */
public class MySelectorClient {
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("192.168.1.95", 8080));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            System.out.println("客户端已准备就绪............");
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isAcceptable()) {
                    isAcceptable(next);
                } else if (next.isConnectable()) {
                    isAcceptable(next);
                } else if (next.isReadable()) {
                    isReadable(next);
                } else if (next.isWritable()) {

                }

            }
        }
    }

    public static void isAcceptable(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel.isConnectionPending()) {
            socketChannel.finishConnect();
        }
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("I am 客户端  输入".getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ);//监听读的时间
    }


    public static void isReadable(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("客户端收到：" + new String(byteBuffer.array()));
    }
}
