package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun
 * @create 2020-10-23 17:43
 */
public class picTest {

    @Test
    public void test1(){

        FileInputStream fis = null;//等价于
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("friendandlove.jpg");
//        FileInputStream fis = new FileInputStream(new File("friendandlove.jpg"))
            fos = new FileOutputStream("friendandlovesecret.jpg");

            byte[] buff = new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1){
                //此时不能使用foreach，因为它是赋值，本身没有改
                for (int i = 0; i < len;i++){

                    buff[i] = (byte)(buff[i] ^ 5);//加密操作
                }
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2(){
        FileInputStream fis = null;//等价于
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("friendandlovesecret.jpg");//解密操作，此时已经是 ^ 5过了，再 ^ 5解密
//        FileInputStream fis = new FileInputStream(new File("friendandlove.jpg"))
            fos = new FileOutputStream("friendandlove4.jpg");

            byte[] buff = new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1){
                //此时不能使用foreach，因为它是赋值，本身没有改
                for (int i = 0; i < len;i++){

                    buff[i] = (byte)(buff[i] ^ 5);//加密操作
                }
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
