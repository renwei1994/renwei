package com.renwei.dome_thread.mythread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestWaitNotify {
    public static void main(String[] args) {
        Queue<String> nums = new LinkedList<>();
        int size = 10;
        Produce produce = new Produce(nums, size);
        Consumption consumption = new Consumption(nums, size);
        Thread thread1 = new Thread(produce);
        Thread thread2 = new Thread(consumption);
        thread1.start();
        thread2.start();
    }
}
