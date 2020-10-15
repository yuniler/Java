package com.atguigu.java;

/**
 *
 *
 * @author sun
 * @create 2020-10-15 20:16
 */
public class StringBufferBuilderTest {

/**
 *
 *
 * StringBuffer方法：
 *          总结
 *          增：append()
 *          删：delete(int start,int end);
 *          改：setCharAt(int n,char ch) / replace(int start,int end,String str);
 *          查：CharAt(int n)
 *          插：insert(int offset, xxx)'
 *          长度：length();
 *          遍历：for () + charAt() /toString()
 *      易错：String substring(int start,int end):返回一个此区间，左闭右开的子区间
 */


    /**
     *
     * 重要：--》
     * String.StringBuffer.StringBuilder三者异同？
     * String:不可变的的字符序列，底层使用char[]来存储
     * StringBuffer:可变的字符序列，线程安全，效率低，底层使用char[]来存储
     * StringBuilder：可变的字符序列，线程不安全，效率高，底层使用char[]来存储
     *
     *
     * String str = new String();//char[] value = new char[0];-->此刻体现了不可变性
     * String str = new String("abc");//char[] value = new char[]{'a','b','c'};
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建一个长度为16位的char[]
     *
     * question1 : sb1.lenght();//0
     * sb1.append('a');//value[0] = 'a';
     * sb1.append('b');value[1] = 'b';
     *
     * StringBuilder sb2 = new StringBuilder("abc");//char[] value = new char["abc".length + 16];
     *
     * question : sb2.lenght();//3
     *
     * 扩容问题： 如果添加底层数据底层数组盛不下，那就需要扩容底层数组
     * 默认扩容原来容量的2倍 + 2，如何在将数组中的元素赋值到原有数组中
     *
     * 推荐使用： StringBuffer(int capacity)    stringBuffer(int capacity)
     *          去自定义大小，省的还要复制
     */
}
