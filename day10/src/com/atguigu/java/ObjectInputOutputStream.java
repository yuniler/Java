package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * 1.ObjectInputStream  ObjectOutputStream
 * 2.存储基本数据类型或对象的处理流
 * 3.要想满足一个对象序列化，满足以下要求，见Person.java
 *
 * @author sun
 * @create 2020-10-24 9:58
 */
public class ObjectInputOutputStream {
    @Test
    public void test1(){
        //先序列化,将你想写的写出转化为看不懂的
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));//持久化。写入持久化，本地
            oos.flush();//刷新
            //自定义一个类，去序列化
            oos.writeObject(new Person("Tom",23));
            oos.flush();//记住带上刷新



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){

        //还原为内存中

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();

            Person p = (Person)ois.readObject();

            String str = (String)obj;
            System.out.println(p);

            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }

}
