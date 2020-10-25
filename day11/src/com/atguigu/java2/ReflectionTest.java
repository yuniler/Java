package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sun
 * @create 2020-10-25 21:02
 */
public class ReflectionTest {

    @Test
    public void testField1() throws Exception {

        Class clazz = Person.class;

        //创建运行时类的对象
        Person p1 = (Person)clazz.newInstance();

        //getDeclaredField(String FieldName):获得运行时类指定变量名的属性
        Field name1 = clazz.getDeclaredField("name");//public

        //保证该属性可访问
//        name1.setAccessible(true);
        name1.set(p1,"Jerry");

        System.out.println(name1.get(p1));


    }

    /**
     *      *************重点
     * 如何操作运行时类指定的方法
     */

    public void testMethod() throws Exception {
        Class clazz = Person.class;
        Person p= (Person) clazz.newInstance();
        /**
         * 获取指定方法
         *
         */

        //1.方法的名称，和    形参列表
        Method show = clazz.getDeclaredMethod("show",String.class);

        show.setAccessible(true);

        Object returnValue = show.invoke(p,"CHA");
        System.out.println(returnValue);

        System.out.println("如何调用方法");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        Object invoke = showDesc.invoke(null);
        System.out.println(invoke);


    }
}
