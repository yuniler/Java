package atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合
 *
 *
 *
 *
 * 二：集合框架
 *      |---Collection接口：单例集合用来存储一个一个的对象
 *          |---List接口：存储有序的。可重复的数据---》“动态数组
 *              |---ArrayList.LinkedList.Vector
 *
 *          |---Set接口
 *              |--HashSet.LinkedHashSet.TreeSet
 *
 *      |---Map接口双列集合，存储一对(key--value)一对数据---》高中函数
 *          |---HashMap.LinkedHashMap.TreeMap.Hashtable.Properties
 *
 *
 *
 * @author sun
 * @create 2020-10-17 17:11
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(Object e)
        coll.add("ABC");
        coll.add(111);
        coll.add(new Date());

        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("BB");
        //addAll()
        //将集合coll1的元素添加到coll集合里
        coll.addAll(coll1);
        //size()获取coll添加的元素个数
        coll.size();
        System.out.println(coll.size());
        System.out.println(coll);//实现类重写的toString

        //clear 清空集合元素
        coll.clear();
        //判断是否为空
        System.out.println(coll.isEmpty());

    }
}
