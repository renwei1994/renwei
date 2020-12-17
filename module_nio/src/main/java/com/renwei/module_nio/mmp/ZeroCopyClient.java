package com.renwei.module_nio.mmp;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/3 0003
 */
public class ZeroCopyClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("192.168.1.95", 8080));

            FileChannel channel = new FileInputStream("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio.md").getChannel();
            long l = channel.transferTo(0, channel.size(), socketChannel);
            System.out.println("总的传输字节数：" + l);
        } catch (Exception e) {

        }
    }
}
