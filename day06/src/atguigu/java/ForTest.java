package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sun
 * @create 2020-10-18 14:09
 */
public class ForTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 19));

        //for (  集合元素类型     局部变量   :  集合对象)
        //底层实现仍然是for
        for (Object obj : coll){
            System.out.println(obj);
        }

    }
    @Test
    public void test1(){

        int[] arr = new int[]{1,2,3,4,5};
        for (int i : arr){
            System.out.println(arr[i]);
        }

    }


    /**
     * 面试题
     */
    @Test
    public void test2(){

        String[] arr = new String[]{"MM","MM","MM"};

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//
//        }

        //此时s是一个新变量
        for(String s : arr){
            s = "GG";

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }
}
