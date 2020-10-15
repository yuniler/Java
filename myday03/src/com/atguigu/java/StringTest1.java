package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *

 * @author sun
 * @create 2020-10-15 17:03
 */
public class StringTest1 {

    /**
     * 编码 String --> byte[]:调用String的getByte()
     * 解码 byte[] _-->String:调用String的构造器
     * @throws UnsupportedEncodingException
     */

    @Test
    public void test3() throws UnsupportedEncodingException {

        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行转换,编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("********************");

        //String str2 = new String(bytes);--->解码
        //
        //String str3 = new String(gbks);--->编码

    }

    /**
     * String 和char[] 之间转换
     * -->char[] 调用String的toCharArray()
     * -->String:调用String的构造器
     */
    @Test
    public void test2(){

        String str1 = "abc123";
        char[] charArray = str1.toCharArray();//调用String的
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);

        }
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }


    /**
     *  * String和基本类型和包装类之间的相互转换
     *  *
     *  * String --> 基本类型：调用包装类方法：parseXxx(str)
     *  * 基本类型 --->String ： 调用String重载的valueOf()
     *  *
     */
    @Test
    public void test1(){
        String str = "123";
        int int1 = Integer.parseInt(str);
        String str1 = String.valueOf(int1);


    }

}
