package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author sun
 * @create 2020-10-25 18:13
 */
public class FieldTest {

    @Test
    public void test1(){


        //getFields():获取当前运行时类及其父类声明为public的属性
        Class clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);

        }

        //getDeclaredFields()获得当前运行类声明的所有属性，不含父类
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符         数据类型        变量名
    @Test
    public void test2(){
        Class clazz= Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.println(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.println(fName);




        }


    }
}
