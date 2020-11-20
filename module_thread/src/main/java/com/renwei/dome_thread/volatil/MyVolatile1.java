package com.renwei.dome_thread.volatil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/17 0017
 */
public class MyVolatile1 {

    int i = 0;
    boolean isfinsh = false;

    public void cpuDo1() {
        new AtomicInteger().incrementAndGet();
        i = 10;
//        storeBarrier()
        isfinsh = true;
    }

    public void cpuDo2() {
        if (isfinsh) {
//            loadBarrier()
            System.out.println(i);
        }
    }

}
