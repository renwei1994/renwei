package com.renwei.dome_thread.synchroniz;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/5 0005
 */
public class MySynchronized1 {

    private static MySynchronized mySynchronized = new MySynchronized();


    public static void main(String[] args) {

        new Thread(() -> {
            try {
                new MySynchronized1().testMySynchronized1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"renwei001").start();

        new Thread(() -> {
            try {
                new MySynchronized1().testMySynchronized2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"renwei002").start();

//        new Thread(() -> {
//            try {
//                new MySynchronized1().testMySynchronized2();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                new MySynchronized1().testMySynchronized2();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                new MySynchronized1().testMySynchronized1();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                mySynchronized.testMySynchronized();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"renwei").start();

    }


    public void testMySynchronized1() throws InterruptedException {
        System.err.println(Thread.currentThread().getName() + "进来 。。。1。。");
        synchronized (mySynchronized) {
            System.out.println(Thread.currentThread().getName() + "进来 。。。1。。");
            Thread.sleep(10000l);
            System.out.println(Thread.currentThread().getName() + "进来 。。。1。。");
        }
    }

    public void testMySynchronized2() throws InterruptedException {
        System.err.println(Thread.currentThread().getName() + "进来 。。。2。。");
        synchronized (mySynchronized) {
            System.out.println(Thread.currentThread().getName() + "进来 。。。2。。");
            Thread.sleep(10000l);
            System.out.println(Thread.currentThread().getName() + "进来 。。。2。。");
        }
    }

}
