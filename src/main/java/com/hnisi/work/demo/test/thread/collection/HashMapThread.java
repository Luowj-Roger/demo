package com.hnisi.work.demo.test.thread.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * HashMap死循环测试
 *
 * 首先HashMap是线程不安全的，其主要体现：
 *
 * #1.在jdk1.7中，在多线程环境下，扩容时会造成环形链或数据丢失。
 * transfer()扩容 造成
 * #2.在jdk1.8中，在多线程环境下，会发生数据覆盖的情况。
 *
 * @author Roger
 * @since 2020/10/5
 */
public class HashMapThread implements Runnable{
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        Thread t1= new Thread(thread0);
        Thread t2= new Thread(thread1);
        Thread t3= new Thread(thread2);
        Thread t4= new Thread(thread3);
        Thread t5= new Thread(thread4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
