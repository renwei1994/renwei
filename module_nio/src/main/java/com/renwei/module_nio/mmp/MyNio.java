package com.renwei.module_nio.mmp;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/27 0027
 */
public class MyNio {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio.md"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio_cp.md"));

        //nio一定是基于流
        // 通道和缓冲区
        //获取输入输出流的通道
        FileChannel channelIn = fileInputStream.getChannel();
        FileChannel channelOut = fileOutputStream.getChannel();

        //建立一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channelIn.read(byteBuffer);//把管道读入缓冲区
        byteBuffer.flip();//buffer由读转为写
        channelOut.write(byteBuffer);//把缓冲区的读入通道
        byteBuffer.clear();
    }
}
