package com.renwei.dome_thread.dome1;

public class ThreadVisibility {
    public  static boolean b = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (b) {
                i++;
                System.out.println("执行..." + i);
            }
            System.out.println("执行结束..." + i);
        });
        thread.start();
        Thread.sleep(1000);
        b = false;
        System.out.println(b);
    }
}
