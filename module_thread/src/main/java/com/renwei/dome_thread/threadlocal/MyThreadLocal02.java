package com.renwei.dome_thread.threadlocal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/8 0008
 */
public class MyThreadLocal02 {
    public static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                Integer index =  threadLocal.get();
                System.out.println(Thread.currentThread().getName() + " 前- " + threadLocal.get());
                index += 5;
                threadLocal.set(index);
                System.out.println(Thread.currentThread().getName() + " 后- " + threadLocal.get());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
