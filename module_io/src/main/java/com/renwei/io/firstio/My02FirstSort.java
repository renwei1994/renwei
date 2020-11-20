package com.renwei.io.firstio;

import java.io.*;
import java.net.Socket;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/20 0020
 */
public class My02FirstSort {

    public static void main(String[] args) throws IOException {
        //磁盘io
        FileInputStream fileInputStream = new FileInputStream("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\11.txt");
        //内存io
        String str = "aaabbb";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        //网络io
        Socket socket = new Socket();
        InputStream inputStream = socket.getInputStream();
    }
}
