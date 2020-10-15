package com.atguigu.java;

import org.junit.Test;

/**
 * @author sun
 * @create 2020-10-15 15:18
 */
public class StringMethodTest {


    /**
     * 第三部分
     */

    @Test
    public void test4(){

        String str1 = "北京尚硅谷教育";//str1本身是不变的
        String str2 = str1.replace('北','东');

        String str3 = str1.replace("北京","东京");

        String str = "12hellow34world56";
        //把字符串中的数字替换成,，如果结果开头和结尾中有，直接去掉
        String string = str.replaceAll("\\d",",").replaceAll("^,|,$","");


        str = "12345";
        //判断str字符串是否全部有数字组成，即1-n个数字
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        tel.matches("0571-\\d{7,8}");//0571-开头，有7道8位

        str = "hello|world|java";
        String[] strs = str.split("\\|");//切割，从| 。。
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\|");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }

    /**
     * 第二部分
     *
     *
     */

    @Test
    public void test3(){


        String str1 = "helloworld";
        boolean b1 = str1.endsWith("rld");//是否以此结尾
        boolean b2 = str1.startsWith("He");
        boolean b3 = str1.startsWith("ll",2);//toffset--->index

        String str2 = "wor";
        System.out.println(str1.contains(str2));
        str1.indexOf("lol");
        str1.indexOf("lo",5);

        str1.lastIndexOf("or");//从后向前--7
        //什么时候indexOf(str)和lastIndexOf(str)返回值相同
        //情况一：存在唯一一个str，二：不存在str



    }




    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");//将字符串连接到此字符串的结尾
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//此时和如何生成的没关系(（)-+=)

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s8);//从第几处开始打印
        String s9 = s7.substring(2,5);//[)前闭后开
        System.out.println(s9);

    }


    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变，为原来
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "   he ll    oo ";
        String s4 = s3.trim();//去掉前后的空格：lg：输入密码，账号
        System.out.println("--------" + s3);
        System.out.println("--------" + s4);
    }
}
