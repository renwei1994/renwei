package com.renwei.dome_thread.condtion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/29-11:54
 */
public class ConditionDemoNotify extends Thread{

    private Lock lock;
    private Condition condition;
    private MyCondtion myCondtion;

    public ConditionDemoNotify(Lock lock, Condition condition, MyCondtion myCondtion) {
        this.lock = lock;
        this.condition = condition;
        this.myCondtion = myCondtion;
    }
    /**
     * synchronized(class){
     *     class.wait();
     * }
     */
    @Override
    public void run() {
        System.out.println("begin - ConditionDemoNotify");
        try {
            lock.lock(); //线程B被阻塞在这个位置，由于被线程A唤醒，所以线程B继续执行
//            condition.signal();//线程B会执行这个方法
            System.out.println("end - ConditionDemoNotify");
//            Thread.sleep(5000l);
            myCondtion.wait();
            System.out.println("end - woainiNotify");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
