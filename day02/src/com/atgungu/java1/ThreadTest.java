package com.atgungu.java1;

/**
 * 线程死锁
 *
 * 1.不同线程占用对方需要的同步资源
 * 都等待对方放弃自己需要的同步资源，形成死锁
 *
 * 2.出现死锁，不会异常，不会提示，所有线程出现阻塞，无法继续
 *      使用同步要避免死锁
 *
 * @author sun
 * @create 2020-10-13 10:16
 */
public class ThreadTest {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized(s2){

                    try {//sleep 导致死锁的概率增大（堵塞）
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("a");//添加
                    s2.append("1");

                    synchronized(s1){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s1){

                    try {//sleep 导致死锁的概率增大（堵塞）
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("c");//添加
                    s2.append("3");

                    synchronized(s2){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }).start();
    }
}
