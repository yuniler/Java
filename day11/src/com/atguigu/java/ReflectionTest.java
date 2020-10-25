package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sun
 * @create 2020-10-25 11:49
 */
public class ReflectionTest {

    //反射之前
    @Test
    public void test1(){
        //1.创建对象
        Person p1 = new Person("Tom",12);
        //2.调用方法。属性
        //2.1属性
        p1.age = 10;

        System.out.println(p1.toString());
        //2.2方法
        p1.show();
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //1.通过反射创建对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);//实际上拿的Person
        Person p1 = (Person) obj;
        System.out.println(p1.toString());

        //2.通过反射调用对象的方法，属性
        Field age = clazz.getDeclaredField("age");
        age.set(p1,10);
        System.out.println(p1.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);

        //通过反射调Person的私有结构。。属性，构造器，方法。。

        //调用私有构造器
        System.out.println("*************************");
        Constructor cons1 =  clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2  =(Person) cons1.newInstance("Jerry");
        System.out.println(p2);


        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"HanMeimei");
        System.out.println(p2);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");//相当于p1.showNation("zhoguo")

        //疑问一：通过直接new的方式，和反射的方式偶读可以调用公共的结构，开发中用哪个
        //直接new
        //反射的特性：动态性
        //反射是否与面向对象的封装矛盾
        //封装解决的是建议你调哪个的问题，而反射解决你能不能调的问题 private

    }

    //3.获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {

        /**
         * 关于java.lang.Class类的理解
         * 1.类的加载过程
         * 程序经过javac.exe命令后，生成一个或多个字节码文件。(.class)结尾
         * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相等于将某个字节码文件
         * 加载到内存中。此过程为类的加载。加载到内存中的类，我们叫做运行时类
         * 此运行时类，作为Class的一个实例
         *
         * Class的实例对应着一个运行时类
         * ，加载到内存中的运行时类，会缓存一段时间，时间内，我们通过不同方式获取此运行时类
         *
         *
         */

        //前3个是相同的运行时类，需掌握，主要是第三个

        //1..调用运行时，类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //2..通过运行时类的对象，调用，getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //3.调用Class的静态方法forName(String classPath)//动态进行。不看加载，看运行
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

//        方式四：
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class aClass = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(aClass);



    }
}
