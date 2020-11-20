package com.renwei.io.firstio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/20 0020
 */
public class My01FirstIo {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\11.txt");
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println(i);
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
