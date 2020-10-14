package com.atgungu.java2;

/**
 * 出现共享数据就联想到线程安全问题
 *
 *
 * 100   线程一和线程二交替打印
 *
 * 1.wait()
 * 2.notify()
 * 3.notifyAll()
 *
 * 1.wait(),notify(),notifyAll()三个方法必须使用在同布代码块和同布方法中,而且调用时必须是同布监视器。如this.wait() obj.wait()
 *
 * 面试：
 * 1.相同点：都可以让线程堵塞
 * 2.不同点：声明的位置--Thread类中声明sleep(),Object 类中声明wait()
 *                      --调用要求：sleep任何情况使用，wait()必须使用同步代码块，和同布方法
 *                      --是否释放同步监视器：如果俩个方法都在同布代码块和同布方法中，stop()会释放锁。。。
 * @author sun
 * @create 2020-10-13 17:55
 */



class Number implements Runnable{

    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(this){

                this.notify();//堵塞线程释放，一将二释放

                if (number <= 100){
                    try {
                        Thread.sleep(100);//虽然阻塞，但不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        this.wait();//wait()方法的线程进入阻塞状态，同时释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
