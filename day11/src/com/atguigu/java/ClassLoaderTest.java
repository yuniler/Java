package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author sun
 * @create 2020-10-25 16:05
 */
public class ClassLoaderTest {


    //Properties():用来读取配置文件
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
        //此时文件默认在当前mudule下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
//        pros.load(fis);

        //方式二，读取文件下的.properties
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("name: " + user + "password: " + password);



    }
}
