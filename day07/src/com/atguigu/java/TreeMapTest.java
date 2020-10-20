package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author sun
 * @create 2020-10-20 18:03
 */
public class TreeMapTest {
    /**
     * 不能使用value排序
     *
     *想TreeMap 中添加key-value,要求key必须是由同一个类创建的对象
     *
     * 因为要按照key进行排序：自然排序。定制排序
     *                      自然排序::实现Comparabe -->重写compareTo
     *                      定制排序::（值使用一次，直接匿名），new comparator()
     *                                  通过compares进行排序
     */
    @Test
    public void test1(){

        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);


        map.put(u1,13);
        map.put(u2,97);
        map.put(u3,54);
        map.put(u4,32);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "<----------->" + entry.getValue());

        }

    }

    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;

                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);


        map.put(u1,13);
        map.put(u2,97);
        map.put(u3,54);
        map.put(u4,32);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "<----------->" + entry.getValue());

        }
    }
}
