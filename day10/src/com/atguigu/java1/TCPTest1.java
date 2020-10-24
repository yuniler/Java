package com.atguigu.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 域名地址测试为127.1.1.0
 * @author sun
 * @create 2020-10-24 15:36
 */
public class TCPTest1 {

    @Test
    //客户端,输出数据
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8891);

            os = socket.getOutputStream();
            os.write("你好，我是客户端ll".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    //服务端，操作数据，要拿
    public void service(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;//字节流
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8891);

            socket = ss.accept();

            is = socket.getInputStream();

            //不建议这样写，会乱码
//        byte[] suff = new byte[20];
//        int len;
//        while ((len = is.read(suff)) != -1){
//            String str = new String(suff,0,len);//文本文件用String拿
//            System.out.println(str);
//
//        }
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
                /*System.out.println(baos.toString());*/
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null){
                try {
                    baos.close();
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
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
