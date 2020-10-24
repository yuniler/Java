package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sun
 * @create 2020-10-24 20:03
 */
public class URLTest {


    public static void main(String[] args) {
        try {
            URL url = new URL("http:localhost:8080/examples/beauty.jpg?user=sda;ds");

            System.out.println(url.getProtocol());//获取URL的协议名
            System.out.println(url.getHost());//获取URL的主机名
            System.out.println(url.getPort());//获得URL的端口号
            System.out.println(url.getPath());//获得URL的文件路径
            System.out.println(url.getFile());//获得.
            System.out.println(url.getQuery());//URL的查询


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
