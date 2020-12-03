package com.renwei.module_nio.mmp;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/28 0028
 */
public class MyNio01 {
    public static void main(String[] args) throws IOException {
        FileChannel reopen = FileChannel.open(Paths.get("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio.md"), StandardOpenOption.READ);
        FileChannel wropen = FileChannel.open(Paths.get("F:\\任卫文档\\学习文档\\咕泡学院\\P5基础部分笔记\\05IO\\02nio-cp.md"),StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        MappedByteBuffer inmap = reopen.map(FileChannel.MapMode.READ_ONLY, 0, reopen.size());
        MappedByteBuffer oumap = wropen.map(FileChannel.MapMode.READ_WRITE, 0, wropen.size());
        System.out.println(reopen.size());
        System.out.println(wropen.size());
        System.out.println(inmap.limit());
        System.out.println(inmap.position());
        byte[] bytes = new byte[inmap.limit()];

        inmap.get(bytes);
        oumap.put(bytes);

        inmap.clear();
        oumap.clear();
    }
}
