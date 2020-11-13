package com.renwei.dome_thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/12 0012
 */
public class MyCyclicBarrier extends Thread {
    @Override
    public void run() {
        System.out.println("汇总数据");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MyCyclicBarrier());
        new MyCyclicBarrier01("线程1", cyclicBarrier).start();
        new MyCyclicBarrier01("线程2", cyclicBarrier).start();
        new MyCyclicBarrier01("线程3", cyclicBarrier).start();
    }

}
