package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author sun
 * @create 2020-10-23 16:28
 */
public class BufferedTest {

    @Test
    public void test1(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("friendandlove.jpg");
            File descFile = new File("friendandlove3.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[10];
            int len;
            while ((len = bis.read(buff)) != -1){
                bos.write(buff,0,len);
                bos.flush();//清空缓冲区（加速）
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

//        bis.close();
//        bos.close();//先关外层流，外层关了，内层自动关
//        fis.close();
//        fos.close();
    }

    @Test
    public void test2(){


        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello4.txt")));

            //方式一
//            char[] buff = new char[10];
//            int len;
//            while ((len = br.read(buff)) != -1){
//                bw.write(buff,0,len);
//            }
            //方式二
            String data;
            while ((data = br.readLine()) != null){

//                bw.write(data + "\n");
                bw.write(data);
                bw.newLine();//提供换行的操作
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
