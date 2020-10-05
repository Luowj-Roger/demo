package com.hnisi.work.demo.test.thread.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Arraylist线程不安全 测试
 *
 * 一个 ArrayList ，在添加一个元素的时候，它可能会有两步来完成：
 * 1. 在 Items[Size] 的位置存放此元素；
 * 2. 增大 Size 的值。
 * 在单线程运行的情况下，如果 Size = 0，添加一个元素后，此元素在位置 0，而且 Size=1；
 * 而如果是在多线程情况下，比如有两个线程，线程 A 先将元素存放在位置 0。但是此时 CPU 调度线程A暂停，
 * 线程 B 得到运行的机会。线程B也向此 ArrayList 添加元素，因为此时 Size 仍然等于 0
 * （注意哦，我们假设的是添加一个元素是要两个步骤哦，而线程A仅仅完成了步骤1），
 * 所以线程B也将元素存放在位置0。然后线程A和线程B都继续运行，都增加 Size 的值。
 * 那好，现在我们来看看 ArrayList 的情况，元素实际上只有一个，存放在位置 0，而 Size 却等于 2。这就是“线程不安全”了。
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
