package atguigu.java2;

import atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 1.  set接口的框架
 *      ---Collection 接口：单列集合用来存储一个个对象
 *              ---Set接口：存储无序，不可以重复的数据--
 *                  --hashSet:Set接口的主要实现类，线程不安全，可以存储null
 *                         --linkedHashSet:HashSet子类，遍历内部数据，可以按照顺序
 *                              对于频繁的遍历，LinkedHashSet效率高于HashSet
 *                  --TreeSet:按某一种属性排序
 * @author sun
 * @create 2020-10-18 20:12
 */
public class CollectionTest {

    /**
     *Set
     *      1.无序性，不代表，随机性。存储的数据在底层数组中并非按照数组索引的顺序去添加，而是根据数据的哈希值决定
     *
     *      2.不可重复性：保证添加的元素按照equals()判断，不能返回true
     */
    @Test
    public void test1(){
        Set hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("abc");
        hashSet.add(new Person("Tom",12));
        hashSet.add(1219);
        hashSet.add(new User("Tom",12));
        hashSet.add(new User("Tom",13));//主要是看地址是否相等

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
