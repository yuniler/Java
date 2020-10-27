package atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置4大核心函数式接口
 *
 * 消费型 Consumer<T>  void accept(T t)
 * 供给型 Supplier<T> T get()
 * 函数型 Function<T,R> R apply(T t)
 * 断定型 Predicate<T> boolean test(T t)
 *
 *
 * @author sun
 * @create 2020-10-27 17:05
 */
public class LambdaTest2 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习累，去买水" + aDouble);
            }
        });

        happyTime(300,adouble -> System.out.println("不买水，买吃的"));
    }



    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){

        List<String> list = Arrays.asList("南京","东京","天津");
        List<String> filterStr1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                 return s.contains("京");
            }
        });
        List<String> filterStr2 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStr2);

        System.out.println(filterStr1);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterlist = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){
                filterlist.add(s);
            }
        }
        return filterlist;

    }

}
