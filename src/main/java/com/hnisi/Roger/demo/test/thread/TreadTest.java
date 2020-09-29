package com.hnisi.Roger.demo.test.thread;

public class TreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread t1= new MyThread();
        MyThread t2= new MyThread();
        MyThread t3= new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
