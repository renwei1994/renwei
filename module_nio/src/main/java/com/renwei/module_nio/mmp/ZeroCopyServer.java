package com.renwei.module_nio.mmp;

import javafx.util.Builder;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/3 0003
 */
public class ZeroCopyServer {
    public static void main(String[] args) {
        try {

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            SocketChannel accept = serverSocketChannel.accept();

            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            FileChannel fileChannel = new FileOutputStream("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio-cp1.md").getChannel();
            int r = 0;
            while (r != -1) {
                r = accept.read(byteBuffer);
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {

        }
    }
}
