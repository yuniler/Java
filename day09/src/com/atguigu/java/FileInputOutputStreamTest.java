package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun
 * @create 2020-10-23 15:37
 */
public class FileInputOutputStreamTest {


    public void copyFile(String srcPath,String descPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File(srcPath);//封成方法
            File file2 = new File(descPath);

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] buff = new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1){
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
    public void testCopyFile(){

        long start = System.currentTimeMillis();

//        String srcPath = "C:\\Users\\sunguangyu\\Desktop\\Trim_1.mp4";
//        String descPath = "C:\\Users\\sunguangyu\\Desktop\\Trim_2.mp4";
        String srcPath = "hello.txt";
        String descPath = "hello3.txt";//没new时，没看，就不会显示错误
        copyFile(srcPath,descPath);

        long end = System.currentTimeMillis();

        long timeES = end - start;
        System.out.println(timeES);
    }

    /**
     * 图片的复制，通过字节流
     *
     * @throws IOException
     */
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File("friendandlove.jpg");
            File file2 = new File("friendandlove2.jpg");

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] buff = new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1){
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


    //字节流可以读字符文件，但如果超过长度，出现乱码；
    @Test
    public void test1() throws IOException {

        File file = new File("hello.txt");

        FileInputStream fis = new FileInputStream(file);

        byte[] cbuff = new byte[5];
        int len;
        while ((len = fis.read(cbuff)) != -1){
            String str = new String(cbuff,0,len);
            System.out.println(str);
        }

        fis.close();
    }



}
