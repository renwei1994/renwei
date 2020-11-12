package com.renwei.dome_thread.threadlocal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/8 0008
 */
public class MyThreadLocal01 {
    public static int index = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                index += 5;
                System.out.println(Thread.currentThread().getName() + " - " + index);
            });
        }


        for (Thread thread : threads) {
            thread.start();
        }
    }

}
