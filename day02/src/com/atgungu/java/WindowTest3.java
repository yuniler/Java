package com.atgungu.java;

/**
 *
 * private synchronized void show()同步方法
 * @author sun
 * @create 2020-10-13 9:03
 */
class Window3 implements Runnable {

    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {//obj表对象，对象才能使用
//            synchronized (this)--this ---> w1此时this代表唯一的Window1的对象
//            }
            show();
        }
    }

    private synchronized void show() {//此时synchronized--->this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }

}


public class WindowTest3 {

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
