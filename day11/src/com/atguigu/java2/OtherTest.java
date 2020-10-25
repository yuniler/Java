package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author sun
 * @create 2020-10-25 20:15
 */
public class OtherTest {

    @Test
    public void test1(){


        Class clazz = Person.class;
        //获得当前运行时类的声明为public构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }

        //获得当前运行时类的全部构造器

        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c1 : constructors1){
            System.out.println(constructors1);
        }

    }


    //获取运行时类的父类
    @Test
    public void test2(){

        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

    }

    //获取运行时类带泛型的父类
    @Test
    public void test3(){

        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    //获取运行时类带泛型的父类的泛型
    @Test
    public void test4(){

        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parame = (ParameterizedType) genericSuperclass;

        //获取泛型类型
        Type[] actualTypeArguments = parame.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());


    }
    //获取运行时类的接口
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();

        //获取运行时父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c1 : interfaces1){
            System.out.println(c1);
        }


    }
    //获取运行时类的pack
    @Test
    public void test6(){
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    //获取运行时类的注解
    @Test
    public void test7(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }


    }


}
