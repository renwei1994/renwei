package com.renwei.dome_thread.condtion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/12 0012
 */
public class MyCondtion {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        MyCondtion myCondtion = new MyCondtion();
        ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock, condition, myCondtion);
        ConditionDemoNotify conditionDemoNotify = new ConditionDemoNotify(lock, condition, myCondtion);
        conditionDemoWait.start();
        conditionDemoNotify.start();
    }
}
