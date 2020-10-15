package com.atguigu.exer;

/**
 *
 * 还是基本数据类型传递数据
 * 引用数据类型传递地址值
 * @author sun
 * @create 2020-10-15 14:34
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    //地址值指向新变量（String有不可变性)
    public void change(String str,char ch[]){//形参是一个新的变量被赋予的地址值，名字只不过一样

        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest st = new StringTest();
        st.change(st.str,st.ch);
        System.out.println(st.str);//good
        System.out.println(st.ch);//best

    }
}
