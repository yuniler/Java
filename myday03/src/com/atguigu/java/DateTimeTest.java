package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 *
 * JDK 8之前日期和时间的API测试
 * @author sun
 * @create 2020-10-15 20:49
 */
public class DateTimeTest {


    /**
     * java.util.Date类
     *       --java.sql.Date类
     * 1.俩个构造器的使用
     *      1：Date():创建一个对应当前时间的对象
     *      2：创建指定毫米数Date对象
     * toString()显示当前---
     * getTime()取当前date对象对应的毫秒数
     */

    @Test

    public void test2(){
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        java.sql.Date date2 = new java.sql.Date(2131231324L);
        System.out.println(date2);

        //将java.util.Date对象转换为java.sql.Date对象
        Date date3 = new java.sql.Date(2131231324L);//向上转型，多态，可以new的是子类
        java.sql.Date date4 = (java.sql.Date)date3;

        Date date5 = new Date();//注意这里new 的父类,不能强制转为子类。。
        java.sql.Date date6 = new java.sql.Date(date5.getTime());
    }



    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
        //用处--》时间戳
    }

}
