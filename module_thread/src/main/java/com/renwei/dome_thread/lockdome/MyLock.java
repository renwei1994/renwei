package com.renwei.dome_thread.lockdome;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/7 0007
 */
public class MyLock {
    //重入锁
    Lock lock = new ReentrantLock();
    public void fun(){
        lock.lock();
    }

}
