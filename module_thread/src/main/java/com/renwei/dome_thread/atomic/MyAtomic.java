package com.renwei.dome_thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/17 0017
 */
public class MyAtomic {
    public static void main(String[] args) {
        new AtomicInteger().incrementAndGet();
    }
}
