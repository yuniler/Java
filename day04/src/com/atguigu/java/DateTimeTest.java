package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 两个操作
 * 掉发SimpleDateFormat
 * 1.格式化：日期---字符串--format
 * 2.解析：解析的逆过程，字符串---日期--parse
 *
 * 2.SimpleDateFormat的实例化
 *
 * @author sun
 * @create 2020-10-16 13:28
 */
public class DateTimeTest {

    /**
     * 练习一：
     * 将2020-08-09 转换为java.sql.Date
     *
     * 练习二：
     *
     * "三天大鱼俩天筛网"==从1990-01-01
     *
     *
     * 2020-09-08? 的总天数
     * 天数 % 5 == 1，2,3：大鱼
     * 天数 % 5 == 4 ，0 ：晒网
     *
     * 天数计算
     * (date2.getTime() - date1.getTime() / (1000 * 60 * 60 * 24) + 1;只有多出来一点，就多加一天
     *
     *
     * @throws ParseException
     */
    @Test
    public void textExer() throws ParseException {
        String time = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(time);

        java.sql.Date timeDate = new java.sql.Date(date.getTime());
        System.out.println(timeDate);//已经调了toString()

    }


    @Test
    public void testSimpleDateFormat() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //逆过程
        String str = "20-10-16 下午1:32";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //按指定方式格式化

        //格式化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str1 = sdf1.format(date);
        System.out.println(str1);

        //解析：要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)

        Date date2 = sdf1.parse("2020-10-16 01:38:18");
        System.out.println(date2);


    }

    @Test
    public void testCalendar(){

        //实例化：
            //创建子类GregorianCalendar的对象
            //调用静态方法
        Calendar calendar = Calendar.getInstance();


//        2.常用方法

        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);//void 返回值，说明直接修改过了
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);//增加操作，减少（-）
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


        //getTime():日历类---》Date

        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date --->r日历类
        Date date1 = new Date();
        calendar.setTime(date1);
    }





}
