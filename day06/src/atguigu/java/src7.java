package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList()
 * @author sun
 * @create 2020-10-18 15:46
 */
public class src7 {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Person("Tom",12));
        list.add(456);


        //1.add
        list.add(1,"BB");
        System.out.println(list);//重写过toString

//        2.addAll(int index,Collection eles) .
        List list1 = Arrays.asList(1,2,3);//将1,2，3t添加
        list.addAll(list1);
        list.add(list);//此时将list作为一个元素了。输出7
        System.out.println(list.size());//9



    }
    public void test2(){
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Person("Tom",12));
        list.add(456);

        //indexOf(Object obj)返回obj在集合首次出现的位置，不存在返回-1
        int i = list.indexOf(123);
        System.out.println(i);//index

        //lastIndexOf(Object obj) 返回末尾出现位置
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index)
        Object obj = list.remove(0);
        System.out.println(obj);

        //Object set(int index,Object eles),指定位置设置
        list.set(1,"cc");
        System.out.println(list);

        //list subList(int fromIndex,int toIndex):返回一个左闭右开的子集和
        List subList = list.subList(2,4);
        System.out.println(subList);


    }
}
