package com.renwei.dome_thread.dome2;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/10/22 0022
 */
public class MySynchronized2 {

    public synchronized static void do11() {
    }

    public void do12() {
        synchronized (MySynchronized2.class) {
        }
    }

    public synchronized static void do21() {
    }

    public void do22() {
        synchronized (this) {
        }
    }
}

