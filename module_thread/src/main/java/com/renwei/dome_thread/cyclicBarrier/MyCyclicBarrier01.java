package com.renwei.dome_thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/12 0012
 */
public class MyCyclicBarrier01 extends Thread {

    private String data;
    private CyclicBarrier cyclicBarrier;

    public MyCyclicBarrier01(String data, CyclicBarrier cyclicBarrier) {
        this.data = data;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(data + "获取中");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(data + "后续逻辑处理中");
    }
}

