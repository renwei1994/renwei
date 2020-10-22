package com.renwei.dome_thread.dome1;

public class ThreadVisibility {
    public static boolean b = true;

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(() -> {
            while (b) {
                System.out.println("执行...");
            }
            System.out.println("执行结束...");
        });
        thread.start();
        Thread.sleep(3000);
        b = false;
        System.out.println(b);
    }
}
