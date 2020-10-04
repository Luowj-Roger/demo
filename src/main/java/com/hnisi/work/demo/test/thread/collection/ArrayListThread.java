package com.hnisi.work.demo.test.thread.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * arraylist线程不安全 测试
 *
 * @author Roger
 * @since 2020/10/4
 */
public class ArrayListThread implements Runnable{
    List<String> list1 = new ArrayList<String>();// 非线程安全
    public void run(){
        //示例ArrayList线程不安全
        try {
            Thread.sleep((int)(Math.random() * 2));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(Thread.currentThread().getName());
    }
}
