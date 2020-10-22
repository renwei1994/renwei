package com.renwei.dome_thread.dome2;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/10/22 0022
 */
public class MySynchronized1 {
    public synchronized static void doMy() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"执行中。。。。。。。。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 =  new Thread(()->{
            MySynchronized1.doMy();
        },"rw001");
        Thread thread2 =   new Thread(()->{
            MySynchronized1.doMy();
        },"rw002");
        Thread thread3 =   new Thread(()->{
            MySynchronized1.doMy();
        },"rw003");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
