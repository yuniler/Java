package com.atgungu.java;

/**
 * 创建三个窗口卖票，
 * <p>
 * 1.卖票，出现重票，错票--》线程安全问题
 * 2.原因：当某个线程操作车票的过程中，尚未操作完成，其他线程参与进来，也操作车票
 * 3.解决：上锁
 * 4.同步机制
 *          补充;实现Runnable 接口中的创建多线程的方式中，我们可以使用this充当同步监视器
 * <p>
 * 方式一：同步代码块
 * <p>
 *
 * synchronized(同步监视器){---》不能包含多了||少了
 * //同步代码
 * }
 * <p>
 * 1.操作共享数据的代码，即为需被同步的代码
 * 2.共享数据：多线程共同操作变量：ticket
 * 3.同步监视器：锁--任何一个类的对象都可以充当锁
 * 要求：多个线程同时用一把锁
 *
 * @author sun
 * @create 2020-10-12 20:14
 */

class Window1 implements Runnable {

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//obj表对象，对象才能使用
//            synchronized (this)--this ---> w1此时this代表唯一的Window1的对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {

    public static void main(String[] args) {
        Window1 w1 = new Window1();

        Thread t1 = new Thread(w1);
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
