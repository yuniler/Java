package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 13:43
 */
public class GenericTest1 {

    @Test
    public void test1(){
        //此时仍为Object类型
        Order o1 = new Order();
        o1.setOrderT(123);
        o1.setOrderT("aaa");

        //实例化时指明类的泛型
        Order<String> o2 = new Order<>("OrderAA",23,"OrderAA::::");
        o2.setOrderT("Order::");

    }

    @Test
    public void test2(){
        //继承后将Order泛型,。实例化对象时，不再需要泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(22);
//        subOrder.setOrderT("w22");false

    }

    @Test
    public void test3(){


        //此时子类也是泛型类
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("SUB");
    }

    @Test
    public void test4(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;
        //泛型不相等，不可以赋值，虽然都是ArrayList

        Person p1 = null;
        Person p2 = null;
    }


    //测试方法
    @Test
    public void test5(){

        //
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);

    }
}
