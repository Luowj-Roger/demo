package com.hnisi.work.demo.test.thread;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable{
    private int ticket =10;
    List<String> list1 = new ArrayList<String>();// 非线程安全
    public void run(){
        /*for(int i=0;i<20;i++){
            if(this .ticket >0){
                System. out.println(Thread.currentThread().getName()+ " 卖票：ticket" +this.ticket--);
            }
        }*/

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