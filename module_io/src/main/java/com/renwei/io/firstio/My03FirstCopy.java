package com.renwei.io.firstio;

import org.omg.CORBA.portable.InputStream;

import java.io.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/20 0020
 */
public class My03FirstCopy {


    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(new File("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\11.txt"));
        FileOutputStream outputStream = new FileOutputStream(new File("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\11cp.txt"));
        FileOutputStream outputStream2 = new FileOutputStream(new File("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\12cp.txt"));
        int p = 0;
        while ((p = inputStream.read()) != -1){
            outputStream.write(p);
        }

        for (int i = 0; i < 255; i++) {
            outputStream2.write(i);
        }


    }
}
