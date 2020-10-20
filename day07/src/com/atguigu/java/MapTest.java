package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 *      Map实现类的结构
 *        Map :双列数据：储存key-value
 *              --HashMap:线程不安全，效率高，可以储存null的key-value
 *                      linkedListMap::保证遍历Map时。按照添加的顺序实现遍历
 *                      在HashMap的基础上，添加了指针
 *                      对于频繁遍历操作，效率高于HashMap
 *
 *              --TreeMap:保证按照添加的key-value进行排序，实现排序遍历，考虑key的自然排序和定制排序
 *                          底层红黑树
 *              ---Hashtable:古老的实现类，：线程安全，效率的 ----不能存储null的key-value
 *                  --Properties:处理配置文件。key和value都是String
 *
 *          HashMap底层
 *              ：数组 + 链表 （JDK7.0以前)
 *               数组 + 链表 + 红黑树 (JDK8.0)
 *
 *
 *   Map结构：
 *          Map中的key:无序的，不可重复。使用set存储key-->key所在类，需重写equals()和HashCode()
 *          Map中的value:无序，可重复，使用Colleaction存储所有value,value 所在类需重写equals
 *          一个键值对：key-value 构成一个Entry对象
 *          Map中的entry:无序的，不可重复的，使用Set存储所有entry
 *
 *
 *          //总结：常用方法
 *          增，添加 put(Object key,Object value)
 *          删，删除 remove(Object key)
 *          改，修改 put(Object key,Object value)
 *          查，查询 get(Object key)
 *          长度:size()
 *          遍历:keySet() /values() / entrySet
 *          插————》没有，因为无序，无法插入
 */
// * @author sun
// * @create 2020-10-19 18:14
// */
public class MapTest {


    @Test
    public void test5(){

        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);


        /**
         * 注意输出时，任然是按照有关哈希存储值来存储。
         */
        //：： 遍历所有key集：keySet()
        Set set = map.keySet();
        Iterator iterator1 = set.iterator();

        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //遍历所有value:values()
        Collection values = map.values();
        for (Object object : values){
            System.out.println(object);
        }


        //遍历所有key-value
        //entrySet()

        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            Object obj = iterator2.next();//拿到entry>装进Object
            Map.Entry entry = (Map.Entry)obj;//是Entry类型，所有可以转
            System.out.println(entry.getKey() + "----------" + entry.getValue());

        }
//        Set entrySet = map.entrySet();
//        Iterator iterator2 = entrySet.iterator();
//        while (iterator2.hasNext()){
//            System.out.println(iterator2.next());
//        }

        //方式二：：
        Set keySet = map.keySet();
        Iterator iterator3 = keySet.iterator();
        while (iterator3.hasNext()){
            Object key = iterator3.next();//用iterator遍历key
//            System.out.prisntln(key);
            Object value = map.get(key);
            System.out.println(key + "---------->>>>>" + value);



        }



    }


    @Test
    public void test4(){

        /**
         *
         */
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //Object get(Object key)
        System.out.println(map.get(45));//通过key找值

        //boolean containsKey(Object key):是否包含指定的key
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        //boolean containsValue(Object key):是否保函指定value
        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();//清空

        //int size():返回map中key-value对的个数

        //isEmpty() :判断当前map是否为空
        System.out.println(map.isEmpty());

        //boolean equals(Object obj): 判断当前map和参数对象obj是否相等




    }

}
