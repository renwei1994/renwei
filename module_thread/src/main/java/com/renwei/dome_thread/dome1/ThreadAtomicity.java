package com.renwei.dome_thread.dome1;

/**
 * 原子性
 */
public class ThreadAtomicity {


    public static int i = 0;

    public void fun (){
        i++;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 1000; j++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
