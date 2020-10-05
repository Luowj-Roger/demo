package com.hnisi.work.demo.test.thread.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * wait/notify用例 模拟生产者消费者模式
 *
 * wait()方法可以使线程进入等待状态，而notify()可以使等待的状态唤醒。这样的同步机制十分适
 * 合生产者、消费者模式：消费者消费某个资源，而生产者生产该资源。当该资源缺失时，消费者
 * 调用wait()方法进行自我阻塞，等待生产者的生产；生产者生产完毕后调用notify/notifyAll()
 * 唤醒消费者进行消费。
 *
 * 对于每个对象来说，都有自己的等待队列和阻塞队列。以前面的生产者、消费者为例，我们拿obj对象作为对象锁，配合图示。内部流程如下
 *
 * 当线程A（消费者）调用wait()方法后，线程A让出锁，自己进入等待状态，同时加入锁对象的等待队列。
 * 线程B（生产者）获取锁后，调用notify方法通知锁对象的等待队列，使得线程A从等待队列进入阻塞队列。
 * 线程A进入阻塞队列后，直至线程B释放锁后，线程A竞争得到锁继续从wait()方法后执行。
 *
 * @author Roger
 * @since 2020/10/4
 */
public class WaitNotifyThread {
    static final Object obj = new Object();  //对象锁

    private static boolean flag = false;

    public static void main(String[] args) throws Exception {

        Thread consume = new Thread(new Consume(), "Consume");
        Thread produce = new Thread(new Produce(), "Produce");
        consume.start();
        Thread.sleep(1000);
        produce.start();

        try {
            produce.join();
            consume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 生产者线程
    static class Produce implements Runnable {

        @Override
        public void run() {

            synchronized (obj) {
                System.out.println("进入生产者线程");
                System.out.println("生产");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);  //模拟生产过程
                    flag = true;
                    obj.notify();  //通知消费者
                    TimeUnit.MILLISECONDS.sleep(1000);  //模拟其他耗时操作
                    System.out.println("退出生产者线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者线程
    static class Consume implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("进入消费者线程");
                System.out.println("wait flag 1:" + flag);
                while (!flag) {  //判断条件是否满足，若不满足则等待
                    try {
                        System.out.println("还没生产，进入等待");
                        obj.wait();
                        System.out.println("结束等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("wait flag 2:" + flag);
                System.out.println("消费");
                System.out.println("退出消费者线程");
            }

        }
    }
}
