package atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 13:48
 */
public class SubOrder extends Order<Integer>{
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }
}
