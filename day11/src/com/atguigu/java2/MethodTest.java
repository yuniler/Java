package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author sun
 * @create 2020-10-25 18:31
 */
public class MethodTest {

    @Test
    public void test1(){

        Class clazz = Person.class;


        //getMethods():获取当前运行时类及其所有父类声明为public 权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method1 : methods){
            System.out.println(method1);
        }
        System.out.println();

        //获取当前运行时类的所有方法，不包括父类
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method2 : methods1){//多了一个private
            System.out.println(method2);
        }


    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods =  clazz.getDeclaredMethods();
        for (Method m : declaredMethods){

            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }

            //2.修饰符
            System.out.println(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.println(m.getName());
            System.out.print("(");

            //5.形参列表

            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length ==0)){
                for (int i = 0; i < parameterTypes.length; i++) {

                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + "args" + i );
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + "args" + i + ",");
                }
            }

            System.out.print(")");


            //6.抛异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0){
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1){
                        System.out.println(exceptionTypes[i].getName() + i);

                    }
                    System.out.println(exceptionTypes[i].getName() + "args" + i + ",");

                }

            }



        }




    }
}
