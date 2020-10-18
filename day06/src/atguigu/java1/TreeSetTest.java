package atguigu.java1;

import atguigu.java2.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * TreeSet
 * @author sun
 * @create 2020-10-18 21:12
 */
public class TreeSetTest {

    //自然排序
    @Test
    public void tes1() {
        TreeSet treeSet = new TreeSet();

        //1.向TreeSet中添加的数据，要求是相同类的对象
        treeSet.add(123);
        treeSet.add(23123);
        treeSet.add(677);


        //列二
        treeSet.add(new User("Tom", 22));
        treeSet.add(new User("Jerry", 35));
        treeSet.add(new User("Jerry", 76));
        treeSet.add(new User("YI", 22));


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){

        Comparator com = new Comparator() {
            //自定义按照年龄
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException("输入类型错误");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom", 22));
        set.add(new User("Jerry", 35));
        set.add(new User("Jerry", 76));
        set.add(new User("YI", 22));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
