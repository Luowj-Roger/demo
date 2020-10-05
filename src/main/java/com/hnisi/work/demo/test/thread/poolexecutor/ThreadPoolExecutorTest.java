package com.hnisi.work.demo.test.thread.poolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 线程池实例
 *
 *
 * 刚创建时，里面没有线程调用 execute() 方法，添加任务时：
 *
 * 如果正在运行的线程数量小于核心参数 corePoolSize ，继续创建线程运行这个任务
 * 否则，如果正在运行的线程数量大于或等于 corePoolSize ，将任务加入到阻塞队列中。
 * 否则，如果队列已满，同时正在运行的线程数量小于核心参数 maximumPoolSize ，继续创建线程运行这个任务。
 * 否则，如果队列已满，同时正在运行的线程数量大于或等于 maximumPoolSize ，根据设置的拒绝策略处理。
 *
 * @author Roger
 * @since 2020/10/5
 */
public class ThreadPoolExecutorTest implements Runnable{

    private int taskNum;

    public ThreadPoolExecutorTest(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        for(int i=0;i<15;i++){
            ThreadPoolExecutorTest myTask = new ThreadPoolExecutorTest(i);
            executor.execute(myTask);
            //executor.submit(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
