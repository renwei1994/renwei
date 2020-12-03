package com.renwei.module_nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/28 0028
 */
public class MySelectorServer {
    static Selector selector;//多路复用器

    public static void main(String[] args) throws Exception {
        //创建一个多路复用器 管理所有连接的注册中心
        selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//构建通道
        serverSocketChannel.configureBlocking(false); //网络io非阻塞  serverSocketChannel.accept()原本是阻塞的方法，只有等到有链接的时候才不阻塞
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));//注册一个监听端口
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//把当前通道注册到selector 监听链接事件

        while (true) {
            System.out.println("服务端已准备就绪............");
            //当时间没到达之前  此方法会阻塞 阻塞所有注册到多路复用器上的事件
            //一旦某个事件处于就绪，那么就会返回
            selector.select();
            //一旦selector.select()返回  那么就会获取所有处于就绪 selectionKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                System.out.println("you ji ge key");
                SelectionKey next = iterator.next();
                iterator.remove();//避免重复处理
                if (next.isAcceptable()) {
                    isAcceptable(next);
                } else if (next.isConnectable()) {

                } else if (next.isReadable()) {
                    isReadable(next);
                } else if (next.isWritable()) {

                }
            }
        }
    }

    /**
     * 链接事件
     *
     * @param key
     */
    public static void isAcceptable(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

        //能走到这里socketChannel一定不为null
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);//io非阻塞
        socketChannel.write(ByteBuffer.wrap("I am 服务端  输入".getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ);//再把读事件注册上去
    }

    /**
     * 读事件
     *
     * @param key
     */
    public static void isReadable(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("服务端读到：" + new String(byteBuffer.array()));
    }

}
