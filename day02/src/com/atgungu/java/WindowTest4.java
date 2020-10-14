package com.atgungu.java;

/**
 * @author sun
 * @create 2020-10-13 9:17
 * 同步方法任然涉及同步监视器，只是不需要显示声明
 * 非静态的同步方法，同步监视器是：this
 * 静态的同步方法：同步监视器是：当前类本身
 */



class Window extends Thread{

    //此时体现static静态。公用一份变量
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){

            show();
        }
    }

    //static的对象是当前类本身
    private static synchronized void show(){//static随着类的加载而加载且值加载一次
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "票号为: " + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();//每次都把ticket1 = 100 都提取了

        w1.start();
        w2.start();
        w3.start();
    }
}



