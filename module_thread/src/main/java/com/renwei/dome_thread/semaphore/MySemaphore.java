package com.renwei.dome_thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/12 0012
 */
public class MySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            new RW(i, semaphore).start();
        }
    }

    static class RW extends Thread {
        private int num;
        private Semaphore semaphore;

        public RW(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获得许可
                System.out.println("第" + num + "  进来");
                Thread.sleep(5000l);
                System.out.println("第" + num + "  出去");
                semaphore.release();//释放许可
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
