package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-20 20:21
 */
public class ColleactionsTest {

    @Test
    public void test2(){

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //异常
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//==list.size()


        //Colleactions 类提供多个synchronizedXxx()包装成线程同步的集合，解决，多线程并发，线程安全问题
        List list1 = Collections.synchronizedList(list);


    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);




        //Colleactions.reverse(list)
//        Collections.reverse(list);
//        Collections.shuffle(list);//随机
//        Collections.swap(list,1,2);//index
        int frequency = Collections.frequency(list, 123);


        System.out.println(frequency);

    }
}
