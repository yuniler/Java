package com.atguigu.java;

import org.junit.Test;

/**
 * @author sun
 * @create 2020-10-16 13:05
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//等于将null看出字符串了

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}
