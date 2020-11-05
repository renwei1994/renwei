package com.renwei.dome_thread.mythread;

import java.util.List;
import java.util.Queue;

public class Consumption implements Runnable {
    private Queue<String> nums;
    private int size;

    Consumption(Queue<String> nums, int size) {
        this.nums = nums;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (nums) {
                if (nums.isEmpty()) {
                    System.err.println("消费完了........");
                    try {
                        nums.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String num = nums.remove();
                System.out.println(Thread.currentThread().getName()+"消费：" + num);
                nums.notifyAll();
            }
        }
    }
}
