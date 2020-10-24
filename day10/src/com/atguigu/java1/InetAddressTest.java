package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * IP:唯一的标识Internet是的计算机（通讯实体）
 *
 * 如何实例化InetAddress的俩个方法:getByName(String host).getLocalHost()
 * l        俩个常用方法：getHostName() //getHostAddresss()
 *
 * 域名：由域名查询IP 如果查询本地IP则通过host
 *
 * 端口号：正在计算机上运行的进程
 * 要求：不同进程有不同的端口号
 * 范围，规定一个16位的整数0-65535
 *
 * 端口号和IP地址的组合得到网络套接字：Socket
 *
 * @author sun
 * @create 2020-10-24 14:40
 */
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            System.out.println(inet2.getHostName());//获得主机的域名

            System.out.println(inet2.getHostAddress());//获得主机的地址


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }


}
