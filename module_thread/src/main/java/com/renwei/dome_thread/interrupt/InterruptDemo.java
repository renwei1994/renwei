package com.renwei.dome_thread.interrupt;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/20-20:55
 */
public class InterruptDemo extends Thread{
    @Override
    public void run() {
        // 检测当前线程的状态：终止状态为true  正常状态为false
        // Thread.currentThread().isInterrupted() 默认false
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("卫哥最帅");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptDemo();
        thread.start();
        Thread.sleep(5000);
        //会将当前线程标记为终止状态
        thread.interrupt();
        //会将当前线程归档为正常状态
        thread.isInterrupted();
    }
}
