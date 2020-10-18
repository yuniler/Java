package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator迭代器
 * @author sun
 * @create 2020-10-18 13:06
 */
public class IteratorTest {
    @Test

    public void test1(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 19));

        //方式一：
        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //报异常
        System.out.println(iterator.next());

        //方式二
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());

        }

        //方式三：推荐
        //hasNext()判断下一个指针是否有元素
        while(iterator.hasNext()){

            //next().指针下移，下移后集合位置上的元素返回
            System.out.println(iterator.next());
        }


    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 19));

        Iterator iterator = coll.iterator();
        if (iterator.next() != null){
            System.out.println(iterator.next());
        }



        //错误二,每次调用都是一个新的iterator对象
        if (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }
    
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 19));

        //删除Tom
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        if (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
