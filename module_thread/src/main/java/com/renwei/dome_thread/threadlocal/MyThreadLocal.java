package com.renwei.dome_thread.threadlocal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/8 0008
 */
public class MyThreadLocal {

    public static int index = 0;

    public void singel() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            index++;//因为index不是原子性操作
            Thread.sleep(1);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    new MyThreadLocal().singel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
        }

        Thread.sleep(3000);
        System.out.println(index);
    }

}
