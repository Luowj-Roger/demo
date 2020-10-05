package com.hnisi.work.demo.test.thread.holdsLock;

/**
 * HoldsLock使用测试
 *
 * @author Roger
 * @since 2020/10/5
 */
public class HoldsLockThread {


    public static void main(String[] args){
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(o) {
                    System.out.println("child thread: holdLock: " +
                            Thread.holdsLock(o));
                }
            }
        }).start();
        System.out.println("main thread: holdLock: " + Thread.holdsLock(o));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
