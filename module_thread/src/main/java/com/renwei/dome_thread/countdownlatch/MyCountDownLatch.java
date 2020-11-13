package com.renwei.dome_thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/12 0012
 */
public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();
        countDownLatch.await();
    }

}
