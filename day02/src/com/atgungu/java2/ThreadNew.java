package com.atgungu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程的方式3：实现Callable接口
 *
 * @author sun
 * @create 2020-10-14 18:11
 */


//1.创建一个Callable的实现类
class NumThread implements Callable{
    //2.实现Callable方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }

        }
        return sum;//Callable可以有返回值
    }
}
public class ThreadNew  {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象

        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用
        new Thread(futureTask).start();//futureTask实现的也是Runnable

        try {
            //6.获得Callable中call方法的返回值
            Object sum = futureTask.get();//get方法的返回值为FutureTask 构造器参数Callable实现类重写的call()的返回值
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    
}
