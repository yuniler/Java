package com.atgungu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 锁---JDK5.0新增
 *
 * 1.面试题 synchronized 与 Lock 异同
 *      相同：二者都可以解决线程安全问题
 *      不同：synchronized 机制执行完同步代码后，自动释放同步监视器
 *      Lock需要手动启动同步(lock)，同时结束同步手动实现(unlock())
 *
 *
 * @author sun
 * @create 2020-10-13 10:47
 */


class Window1 implements Runnable{

    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {

            //2.调用锁定方法
            lock.lock();
            while (true){
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }finally {
            //3.调用解锁方法 unlock()
            lock.unlock();
        }
    }
}




public class LockTest {
    public static void main(String[] args) {
        Window1 w1 = new Window1();//只创建了一个Window1的对象，只有1份ticket。
        //3个线程调用一个对象

        Thread t1 = new Thread(w1);//3个线程一个对象
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

