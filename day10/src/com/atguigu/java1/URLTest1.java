package com.atguigu.java1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author sun
 * @create 2020-10-24 20:14
 */
public class URLTest1 {

    public static void main(String[] args) {

        HttpURLConnection urlconnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://img.ivsky.com/img/bizhi/pre/201303/09/michael_jordan-001.jpg");
            urlconnection = (HttpURLConnection) url.openConnection();

            urlconnection.connect();

            is = urlconnection.getInputStream();
            fos = new FileOutputStream("day10\\qiao111.jpg");

            byte[] suff = new byte[1024];
            int len;
            while ((len = is.read(suff)) != -1){
                fos.write(suff,0,len);
            }

            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlconnection != null){
                    urlconnection.disconnect();
            }
        }








    }
}
