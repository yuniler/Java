package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sun
 * @create 2020-10-24 18:58
 */
public class TCPTest3 {

    @Test
    public void client() throws IOException {

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9760);
        OutputStream os = socket.getOutputStream();
        FileInputStream fos = new FileInputStream("yao.jpg");
        byte[] buffer = new byte[20];
        int len;
        while ((len = fos.read(buffer)) != -1){

            os.write(buffer,0,len);
        }

        //关闭数据的输出。。表示已经传完了。不用在继续传
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        //保证不出现乱码,打出字符
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] suffer = new byte[10];
        int len1;
        while ((len1 = is.read(suffer)) != -1){
            baos.write(suffer,0,len1);
        }
        System.out.println(baos.toString());

        os.close();
        fos.close();
        socket.close();
        baos.close();
    }

    @Test
    public void service() throws IOException {

        ServerSocket ss = new ServerSocket(9760);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("yao4.jpg");
        byte[] buffer = new byte[10];
        int len;
        //明确得到指示shut...
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);

        }


        //6和客户端交互

        OutputStream os = socket.getOutputStream();
        os.write("你好姚明我收到了".getBytes());


        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();


    }
}
