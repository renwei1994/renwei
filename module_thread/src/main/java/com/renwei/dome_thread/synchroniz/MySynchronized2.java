package com.renwei.dome_thread.synchroniz;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/17 0017
 */
public class MySynchronized2 implements Runnable {
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            MySynchronized2 mySynchronized2 = new MySynchronized2();
            new Thread(mySynchronized2).start();
        }
        Thread.sleep(3000l);
        System.out.println(i);
    }
}
