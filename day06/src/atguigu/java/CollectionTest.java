package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法测试
 *
 * Collection 接口实现类对象添加数据obj.,要求obj所在类重写方法
 * @author sun
 * @create 2020-10-18 9:33
 */
public class CollectionTest {
    @Test
    public void test1() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 19));

//        contains(Object obj) 判断当集合是否包含obj

        boolean contains = coll.contains(123);
        System.out.println(contains);
        //1.contains 调的是equals
        System.out.println(coll.contains("Tom"));//String重写了equals()

        System.out.println(coll.contains(new Person("Jerry", 20)));//false-->true


        //2.Arrays.asList
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll1);
        coll.addAll(coll1);

    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //3.remove
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",19));
        System.out.println(coll);

        //4.removeAll
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);

        //coll1 和coll2的交集
        //5.retainAll
        Collection coll2 = Arrays.asList(123,456,789);
        coll.retainAll(coll2);
        System.out.println(coll1);

    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //equals -->需要保证当前集合和形参集合的元素相等，保证一定相等，包括顺序
        Collection coll1 = Arrays.asList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry",19));
        //6.equals
        coll.equals(coll1);

    }
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //7.hashCode():返回当前对象的哈希值

        System.out.println(coll.hashCode());

        //8.集合---》数组((遍历
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //9.数组---》集合：调用Arrays类的静态方法asList()

        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());
        List arr2 = Arrays.asList(new int[]{123,456});
        System.out.println(arr2.size());



        //iterator: Interator接口实例，遍历集合元素，

    }
}
