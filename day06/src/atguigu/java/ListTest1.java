package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-18 19:49
 */
public class ListTest1 {

    @Test
    public void testListRemove(){

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);


    }
    public static void updateList(List list){
        list.remove(2);//删的是索引为2的value
//        list.remove(new Integer(2));。直接删2
    }
}
