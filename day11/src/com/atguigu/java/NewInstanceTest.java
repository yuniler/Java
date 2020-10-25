package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author sun
 * @create 2020-10-25 16:33
 */
public class NewInstanceTest {


    @Test
    public void test1() throws IllegalAccessException, InstantiationException {


        Class clazz = Person.class;

        /**
         * NewInstance():调用此方法，创建对应运行时类对象，内部调用相应运行时类方法
         *
         * 要想正常创建运行时类对象，要求
         *      1.运行时类必须提供空参构造器
         *      2.空参构造器的访问权限需够，设置为 public
         *
         *      javabean 中要求提供空参构造器的原因
         *      1.编译通过反射，创建运行时类的对象
         *      2.便于子类继承运行时类，默认调用super(),保证父类有次构造器

         */
        Object obj = clazz.newInstance();//此时为Person类的实例
        System.out.println(obj);
    }


    /**
     * 编译时无法确定造的那个对象，只有编译以后，运行时，才可以确定
     * 体现：反射的动态性
     */
    @Test
    public void test3() {
        int num = new Random().nextInt(3);//0.1.2
        String classPath = "";

        switch (num){

            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.atguigu.java.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    //方法：创建一个指定类的对象..获得实例
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }


}
