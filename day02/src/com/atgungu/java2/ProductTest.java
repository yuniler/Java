package com.atgungu.java2;

/**
 * @author sun
 * @create 2020-10-14 15:33
 */

class Clerk{//都有共享的Clerk

    int productCount = 0;

    //俩个同步监视器this都是对一个对象,此执行，下封锁
    public synchronized void produceProduct() {
        if (productCount < 20){
            productCount++;//初始为0保证第一次为一
            System.out.println(Thread.currentThread().getName() + "开始生产产品" + productCount);

            notify();//只要生产一个产品就可以唤醒消费
        }else {
//            wait()
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeConduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费产品 " + productCount);
            productCount--;//消费结束-1
            notify();//只要消费了一个产品就可以把对方唤醒：因为生产最多20
        }else {
//            wait()
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName() + " : 开始购买");
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeConduct();
        }
    }
}
class Producer extends Thread{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产");

        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();

    }

}
