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
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"执行中。。。。。。。。。。");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MySynchronized1 mySynchronized1 = new MySynchronized1();
        MySynchronized1 mySynchronized2 = new MySynchronized1();

        Thread thread1 =  new Thread(()->{
            MySynchronized1.doMy();
        },"rw001");
        Thread thread2 =   new Thread(()->{
            MySynchronized1.doMy();
        },"rw002");
        Thread thread3 =   new Thread(()->{
            mySynchronized1.doMy();
        },"rw003");
        Thread thread4 =   new Thread(()->{
            mySynchronized2.doMy();
        },"rw004");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
