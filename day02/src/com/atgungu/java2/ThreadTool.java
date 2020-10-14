package com.atgungu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程的创建方式方法四。
 *
 * @author sun
 * @create 2020-10-14 18:47
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

public class ThreadTool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池，
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;//向下强制转换
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        System.out.println(service.getClass());
        //2.执行指定的线程操作，需要提供实现Runnable接口或Callable接口类的对象
        service.execute(new NumberThread());//适应Runnable
        service.execute(new NumberThread1());//适应Runnable
//        service.submit();
        service.shutdown();
    }
}
