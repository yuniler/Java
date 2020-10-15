package com.atguigu.java;

import org.junit.Test;

/**

 * @author sun
 * @create 2020-10-15 12:07
 */

public class StringTest {


    /**
     *
     * final修饰的变量为常量
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4此时被修饰为常量了
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }




    /**
     * 常量和常量的拼接结果在常量池，而常量池不会存在相同的常量
     * 只要对比结果有一个为-----变量----，则在堆空间中
     * 拼接结果调用intern()方法中，返回值在常量池中
     */
    @Test
    public void test3(){
        String s1 = "JavaEE";
        String s2 = "hadoop";

        String s3 = "JavaEEhadoop";
        String s4 = "JavaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false


        String s8 = s7.intern();//指向常量池
        System.out.println(s3 == s8);


    }



    /**
     * //String 的实例化方式
     *     //1.通过字面量定义方式
     *     //2.通过new + 构造器的方式
     *
     *
     *     //面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
     *             //俩个：一个是堆空间new的结构，另一个是char[]对应的常量池的数据"abc"
     */
    @Test
    public void test2(){

        //通过字面量定义方式，此时s1和 s2的数据javaEE声明在方法区中的字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        //通过构造器的方式，此时s3和s4保存的地址值，是数据在堆空间开辟空间后对应的地址值
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false


        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name.equals(p2.name));//True
        System.out.println(p1.name == p2.name);//Ture       ---Tom指向同一个方法区的常量池

    }



    /**
     * * String :字符串，使用一对""引起来
     *  *  1.String声明为final的，，不可被继承
     *  *  2.String实现了Serializable 接口：表示字符串是支持序列化
     *  *          实现了Comparable 接口：表示String可以比较大小
     *  *  3.String内部定义了final char[] value用于存储字符串的数据
     *  *  4.String:代表不可变的字符序列：有不可变性
     *  *      ---》1.对字符串重新赋值是，需要重写指定内存区域赋值，不能使用原有value进行赋值
     *  *          2.对现有字符串连接操作，要重新指定内存区域赋值，不能使用原来value
     *  *          3.调用String 的replace()方法修改字符
     *  *  5.通过字面量的方式（区别new)给字符串赋值，该字符串声明在字符串常量池中
     *  *  字符串常量池不会存储相同的字符串的
     *  *
     */
    @Test
    public void test1(){
        String s1 = "abc";//注意此处为字面量的定义方式
        String s2 = "abc";
        s1 = "hello";

    System.out.println(s1 == s2);//比较地址值


    System.out.println(s1);//hello
    System.out.println(s2);//abc

    String s3 = "abc";
    s3 += "def";
    System.out.println(s3);//abcdef

    String s4 = "abc";
    String s5 = s4.replace('a','m');
    System.out.println(s5);//mbc


}


}
