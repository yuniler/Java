package atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 13:40
 */
public class Order<T> {

    String orderName;
    int orderAge;

    T orderT;

    public Order(){
        //编译不通过
//        T[10] arr = new T[10];
        //此时虽然不报错，但为Object类型
        T[] arr =(T[]) new Object[10];

    };

    public Order(String orderName, int orderAge, T orderT) {
        this.orderName = orderName;
        this.orderAge = orderAge;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderAge=" + orderAge +
                ", orderT=" + orderT +
                '}';
    }
    //1.  注意static是随着类的加载而加载。此时实例化的泛型还没加载，不能使用---》static 不能使用类的泛型
//    public static void show(T OrderT){
//        System.out.println(orderT);
//
//
//    }

    //2.异常类不能带泛型处理



    //泛型方法独立于泛型类和接口
    //          List<E>为返回值类型
    //泛型方法可以static ，因为调用后在加载:原因，泛型参数是调用方法确定的，并非在实例化时确定
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }

}
