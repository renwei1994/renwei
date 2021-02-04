package com.renwei.dome_thread.mythread;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2021/2/4 0004
 */
public class MyJoin extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyJoin();
        t.start();

        System.out.println(System.currentTimeMillis());
        t.join(1000);
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void run() {
        System.out.println(123);
    }
}
