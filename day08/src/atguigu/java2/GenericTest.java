package atguigu.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 18:20
 *
 * 类A是类B的父类，G(A)和G(B)二者不具备子分类关系
 *
 * 类A是类B的父类，A(G) B(G),可以
 */
public class GenericTest {

    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;//向上转型，把子类的对象赋给父类的引用

        List<Object> str1 = null;
        List<String> str2 = null;

//        str1 = str2;//涉及泛型，赋值

//        show(str1);
//        show(str2);方法已经声明泛型类型

    }

    public void show(List<Object> list){

    }

    //这样可以
    @Test
    public void test3(){
        AbstractList list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();


    }

    //通配符 ?
    @Test
    public void test4(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

        System.out.println(list);
        System.out.println(list);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        //对于List<?>就不能向内部添加元素，除了null
        list = list3;
//        list.add("AA");

        //允许读取，读取类型为Object的数据类型
        Object o = list.get(1);//不管得到什么类型，总会返回给Object的
        System.out.println(o);

    }
    //这个遍历其实也是读取操作
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();//Obj是所有类的父类
        }
    }


}
