package com.renwei.module_executor.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/16 0016
 */
public class MyFutureTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000L);
        System.out.println("rneweinishiyige1");
        return "renwei";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyFutureTask myFutureTask = new MyFutureTask();
        FutureTask futureTask = new FutureTask(myFutureTask);
        new Thread(futureTask).start();
        System.out.println("111111111");
        System.out.println(futureTask.get());
    }
}
