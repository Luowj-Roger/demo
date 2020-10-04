package com.hnisi.work.demo.test.thread.collection;

import com.hnisi.work.demo.test.thread.MyRunnable;

/**
 * arraylist线程不安全测试 main方法
 *
 * @author Roger
 * @since 2020/10/4
 */
public class ArrayListThreadMain {

    public static void main(String[] args) {
        ArrayListThread mt= new ArrayListThread();
        ThreadGroup group = new ThreadGroup("mygroup");
        for (int i = 0; i < 10000; i++) {
            Thread th = new Thread(group, mt,String.valueOf(i));
            th.start();
        }
        try {
            //返回此线程组及其子线程组中活动线程数量的估计值。
            // 递归地遍历此线程组中的所有子组。 如果当前线程组已经destroyed，返回0
            while (group.activeCount() > 0) {
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(mt.list1.size()); // it should be 10000 if thread safe collection is used.

    }
}
