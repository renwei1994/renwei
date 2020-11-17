package com.renwei.module_executor.executor;

import java.util.concurrent.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/13 0013
 */
public class MyExecutor implements Runnable {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new MyExecutor());
//        }
//        executorService.shutdown();


        ExecutorService executorService =new MyFirstThredPool(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 100; i++) {
            executorService.execute(new MyExecutor());
        }
        executorService.shutdown();


    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


}
