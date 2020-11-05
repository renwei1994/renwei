package com.renwei.dome_thread.synchroniz;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/5 0005
 */
public class MySynchronized {


    public static void main(String[] args) {
        MySynchronized mySynchronized = new MySynchronized();

        new Thread(()->{
            try {
                new MySynchronized().testMySynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                new MySynchronized().testMySynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                new MySynchronized().testMySynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }



    public void  testMySynchronized() throws InterruptedException {
        System.err.println(Thread.currentThread().getName()+"进来 。。。。。");
        synchronized (MySynchronized.class){
            System.out.println(Thread.currentThread().getName()+"进来 。。。。。");
            Thread.sleep(10000l);
            System.out.println(Thread.currentThread().getName()+"进来 。。。。。");
        }
    }


}
