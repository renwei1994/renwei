package com.renwei.dome_thread.condtion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/29-11:54
 */
public class ConditionDemoWait extends Thread {

    private Lock lock;
    private Condition condition;
    private MyCondtion myCondtion;

    public ConditionDemoWait(Lock lock, Condition condition, MyCondtion myCondtion) {
        this.lock = lock;
        this.condition = condition;
        this.myCondtion = myCondtion;
    }

    /**
     * synchronized(class){
     * class.wait();
     * }
     */
    @Override
    public void run() {
        System.out.println("begin - ConditionDemoWait");
        try {
            lock.lock();//ThreadA获得了锁
//            condition.await(); //阻塞
            System.out.println("end - ConditionDemoWait");
//            Thread.sleep(5000l);
            myCondtion.wait();
            System.out.println("end - woainiWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
