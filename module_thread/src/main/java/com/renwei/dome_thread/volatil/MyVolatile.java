package com.renwei.dome_thread.volatil;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.renwei.dome_thread.synchroniz.MySynchronized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/6 0006
 */
public class MyVolatile {
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    public volatile static boolean b = false;
    public static void main(String[] args) throws InterruptedException {

        local.get();

        new Thread(() -> {
            int i = 0;
            while (!b) {
//                System.err.println("result:"+i);
                i++;
            }
            System.out.println("result:"+i);

        }).start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        b = true;
    }

//    //volatile可以解决可见性、[有序性]
//    public  static boolean stop=false;
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread=new Thread(()->{
//            int i=0;
//            while(!stop){
//                i++;
//            }
//            System.out.println("result:"+i);
//        });
//        thread.start();
//        System.out.println("begin start thread");
//        Thread.sleep(1000);
//        stop=true; //主线程中修改stop的值
//    }


}
