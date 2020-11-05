package com.renwei.dome_thread.mythread;

import java.util.Queue;

public class Produce implements Runnable {
    private Queue<String> nums;
    private int size;

    Produce(Queue<String> nums, int size) {
        this.nums = nums;
        this.size = size;
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (nums) {
                if (nums.size() == size) {//一直生产

                    //如果生产满了，那么就停止生产
                    System.err.println("生产满了.........");
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
                System.out.println(Thread.currentThread().getName()+"生产:nums" + i);
                //生产num
                nums.add("nums" + i);
                nums.notifyAll();
            }
        }
    }
}
