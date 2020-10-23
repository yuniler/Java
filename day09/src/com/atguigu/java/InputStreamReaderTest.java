package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * InputStreamReader:将字节的输入流转换为字符的输入流
 * OutputStreamWriter:将字符的输出流，转为字节的输出流
 * @author sun
 * @create 2020-10-23 19:50
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        char[] cbuff = new char[20];
        int len;
        while ((len = isr.read(cbuff)) != -1){
            String str = new String(cbuff,0,len);
            System.out.println(str);
        }

        isr.close();
    }

    @Test
    public void test2() throws Exception {


        File file1 = new File("hello1.txt");
        File file2 = new File("hello1_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        char[] buff = new char[20];
        int len;
        while((len = isr.read(buff)) != -1){
            osw.write(buff,0,len);
        }

        isr.close();
        osw.close();
    }


}
