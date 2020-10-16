package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * JDK8.0用户才可以使用
 * 类似于calener
 * @author sun
 * @create 2020-10-16 15:38
 */
public class JDK8DateTest {



    @Test
    public void test1(){
        LocalDate ld = LocalDate.now();//调当前时间
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();//常用

        //设置指定。年月日--都没有偏差了
        LocalDateTime ldt1 = LocalDateTime.of(2020,10,11,23,5);

        //getXxx
        ldt.getDayOfMonth();
        ldt.getDayOfWeek();
        ldt.getMonth();
        ldt.getMonthValue();
        ldt.getMinute();

        //不可变性
//        withXxx设置---
        LocalDate localDate = ld.withDayOfMonth(22);

        //加++ --
        LocalDateTime localDateTime = ldt.plusDays(3);
        LocalDateTime minus = ldt.minusHours(3);
    }

    /**
     * 类似--java.sql.Date
     */
    @Test
    public void test2(){
        //获取0时区对应时间
        Instant instant = Instant.now();
        System.out.println(instant);


        //修改偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//东八
        System.out.println(offsetDateTime);

        //从1970开始的毫秒
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //通过毫秒找对应时间
        Instant instant1 = Instant.ofEpochMilli(1602835491142L);
        System.out.println(instant1);
    }

    /**
     * 格式化或解析日期
     */
    @Test
    public void test3(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


        //重点：自定义格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter1.format(LocalDateTime.now());
        System.out.println(str4);
    }
}
