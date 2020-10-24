package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 2.即可以输入有可以输出
 * 1.继承了Object类,实现了DataInput和DataOutput接口
 *
 * RandomAccessFile作为输出流，如果写出文件不存在，执行中最多创建
 *      如果存在，对原有文件进行覆盖，从最开始，覆盖--类似char[]
 *
 *
 *
 *
 * @author sun
 * @create 2020-10-24 10:57
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("friendandlove.jpg"),"r");
            raf2 = new RandomAccessFile(new File("friendandlove1.jpg"),"rw");

            byte[] buff = new byte[1024];
            int len;
            while ((len = raf1.read(buff)) != -1){
                raf2.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");
        raf.seek(3);//将指针调整到角标为3的位置
        raf.write("xyz".getBytes());
        raf.close();
    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");
        //将指针为3后的所有数据保持到StringBuilder中
        StringBuilder sb = new StringBuilder((int)new File("hello.txt").length());
        byte[] buff = new byte[1024];
        int len;
        while ((len =raf.read(buff)) != -1){
            sb.append(new String(buff,0,len));//将3后的填入Builder
        }
        raf.seek(3);
        raf.write("xyz".getBytes());

        //将StringBuilder中的数据写入文件
        raf.write(sb.toString().getBytes());

        raf.close();


    }
}
