package com.atgungu.java;

/**
 * @author sun
 * @create 2020-10-13 8:45
 *          继承Thread类创建多线程，慎用this当监视器
 */


class Window2 extends Thread{

    //此时体现static静态。公用一份变量
    private static int ticket = 100;
    private static Object obj = new Object();//此时，3个对象锁只能用一个,声明static

    @Override
    public void run() {
        while (true){
            //正确的
            synchronized(obj){
//            synchronized(Window.class){-->Class clazz = Window2.class,Window.class 只会加载一次
            //错误的
//            synchronized(this){-->继承类的多线程，慎用this，this此时有多个对象
                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "票号为: " + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();//每次都把ticket1 = 100 都提取了

        w1.start();
        w2.start();
        w3.start();
    }
}



