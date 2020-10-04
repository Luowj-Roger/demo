package com.hnisi.work.demo.test.thread.Interrupte;

/**
 *  Interrupte 中断协议 测试
 *
 * 可响应中断线程通常指线程处于阻塞状态时，如果收到中断信号时，是否会取消阻塞状态，所以也叫
 *  可取消的阻塞状态中的线程。如上面所述，可取消阻塞状态更像一种机制，java中Thread.sleep(), Object.wait(),
 *  Thread.join()等都实现了这种机制，所有当你使用sleep这些方式时，java会从语法级别强制你使用try...cacth...语句接
 *  收InterruptedException，即阻塞中的线程如果收到中断信号，会通抛出InterruptedException异常将具体响应处理转移给
 *  开发者，同时把中断状态置为true，我们可以看sleep等方法的源码，这些方法中都会调用Thread.interrupted()对中断状态
 *  进行复位。而像Thread.suspend, Thread.stop这些方式，也是因为由于没有使用可中断机制而被jdk早早Deprecated。
 *
 * @author Roger
 * @since 2020/10/4
 */
public class InterrupteThread extends Thread{
    public void run(){
        /*while(true){
            //①非阻塞中的线程，可以如下代码检测线程中断信号:
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Someone interrupted me.");
            }
            else{
                System.out.println("Thread is Going...");              }
        }*/
        try {
            //②即阻塞中的线程如果收到中断信号，会通抛出InterruptedException异常将具体响应处理转移给开发者，
            // 同时把中断状态置为true
            Thread.sleep(3000);
            while(true){
                System.out.println("Thread is Going...");
            }
        } catch (InterruptedException e) {
            System.out.println("Someone interrupted me.");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        InterrupteThread  t = new InterrupteThread ();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }


}
