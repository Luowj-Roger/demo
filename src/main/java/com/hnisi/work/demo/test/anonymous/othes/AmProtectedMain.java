package com.hnisi.work.demo.test.anonymous.othes;

import com.hnisi.work.demo.test.anonymous.AmProtectedClasses;

public class AmProtectedMain {
    public static void main(String[] args){
        //new AmProtectedClasses().test();//不在一个包下会报错

        //使用匿名内部类
        new AmProtectedClasses(){
            void callParentTeest(){
                super.test();
            }
        }.callParentTeest();

        //线程也使用的匿名内部类
        new Thread(){
            public void run(){
                System.out.println(getName());
            }
        }.start();

    }
}
