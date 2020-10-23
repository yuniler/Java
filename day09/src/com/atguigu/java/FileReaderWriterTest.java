package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sun
 * @create 2020-10-23 13:55
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");//从main进入相当mudule
        System.out.println(file.getAbsolutePath());

        //正确
        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());

    }

    @Test
    public void test() throws IOException {
        FileReader fr = null;
        try {
            //1.实例化，表明操作文件
            File file = new File("hello.txt");

            //2提供具体流 ---(此时为读取)
            fr = new FileReader(file);

            //方式一
            //3。数据读取。read:返回读入的一个字符。到文件末尾返回-1
//            int data = fr.read();
//            while (data != -1){//此时判断时是int类
//                System.out.print((char) data);//输出时char类
//                data = fr.read();
//
//            }
            //方式二
            int data;
            while ( (data = fr.read()) != -1){
                System.out.println((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if (fr != null){//保证fr被实例化过，如果前面线程断掉。
                    fr.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

//            if (fr != null){//保证fr被实例化过，如果前面线程断掉。
//                try {
//                    fr.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

        }




    }


    @Test
    public void test2() throws IOException {

        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            //读入
            char[] cbuf = new char[5];
            int len;
            while (( len = fr.read(cbuf)) != -1){
//                //写法一
////                错误
////                for (int i = 0; i < cbuf.length; i++) {
////                    System.out.print(cbuf[i]);
////
////                }
//                //正确。。len起到记录读进去的个数,长度
//                for (int i = 0; i < len;i++){
//                    System.out.print(cbuf[i]);
//                }

                //写法二
//                String str = new String(cbuf);//相当于错误1
//                System.out.println(str);

                //注意这String构造器和read的构造器很像别搞错了
                String str = new String(cbuf,0,len);
                System.out.println(str);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    /**
     * 1.写出操作
     * 2.
     * File对应硬盘中的文件不存在，输出时自动创建
     * File对应硬盘中的文件存在
     *          如果流的构造器：FileWriter(file,false) / FileWriter(file):对原有进行覆盖，
     *          如果流的构造器：FileWriter(file,true) 对流进行原有基础上的添加，
     * @throws IOException
     */

    @Test
    public void test3() throws IOException {
        FileWriter fw = null;

        try {
            //写出
            File file = new File("hello1.txt");
            fw = new FileWriter(file,true);

            fw.write(" I have a dream\n");
            fw.write("you need have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){

                fw.close();//注意流的关闭
            }
        }


    }

    @Test
    public void test4(){

        FileReader fr = null;
        FileWriter fw = null;
        try {
//            File file1 = new File("hello.txt");
//            File file2 = new File("hello2.txt");
            File file1 = new File("friendandlove.jpg");
            File file2 = new File("friendandlove1.jpg");


            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] cbuff = new char[5];
            int len;//每次读入读入到cbuff数组中的字符个数
            //将字符长度读入len
            while ((len = fr.read(cbuff)) != -1){
                //len即，每次写出len个字符
                fw.write(cbuff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

//            //方法一
//            if (fr != null){
//
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        fw.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }//二者可以并列，catch之后就捕获异常了

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
