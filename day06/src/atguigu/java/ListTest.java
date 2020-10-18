package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Collection接口：单列集合，存储一个个对象
 *       List:存储有序，可重复的数据，
 *              1.ArrayList:List接口的主要实现类；线程不安全，效率高，底层使用Object[] elementData存
 *              2.LinkedList:频繁的插入，删除操作，用此类效率高于ArrayList,底层使用双链表
 *              3.Vertor:List  jdk1.0   线程安全，效率低，底层使用Object[] elementData存储
 *
 *
 *
 *
 *              2.1ArrayList源码分析
     *              jdk7.0--》
     *              ArrayList list = new Arraylist()//底层创建长度为10的Object数组elementData
     *              list.add(123);   elementData[0] = new Integer(123);
     *
     *              list.add(11);//如果添加时，底层elementData数组长度已满，则扩容
     *              每次扩容为原来的1.5倍，同时将原数组转移到新数组中
     *
     *              //开发中建议ArrayList list = new ArrayList(int capacity).将长度写好
     *
     *
     *              jdk 8 中。
     *              ArrayList list = new Arraylist();//底层Object[] elementData初始化为{}.没有初始化长度
     *
     *              list.add(123)//第一次调用时，底层创建长度为10、、
     *
     *              j总结：：：jdk7中的ArrayList对象创建类，相当于单列的饿汉式。。jdk8--懒汉式
     *              懒汉式，延迟数组的创建，节省内存
 *
 *              2.2 LinkedList源码
 *
 *                  LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *                  list.add(123); //将123封装到Node,创建Node对象
 *
 *                  Node定义为：体现双链表的说法
 *
 *
 *
 *
 *
 *              常用方法：
 *              增 add add(Object obj)
 *              删 remove    remove(int index)\ remove(Object obj)
 *              改set  set(int index,Object ele)
 *              查get    get(int index)
 *              插   add(int index,Object ele)
 *              长度size()
 *              遍历--->
 *                      Iterator迭代器
 *                      增强for循环
 *                      for循环
 * @author sun
 * @create 2020-10-18 14:46
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("AA");

        //1.Iterator迭代器遍历
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        //2.增强for
        for (Object obj : coll){
            System.out.println(obj);
        }
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(coll.get(i));

        }


    }
}
