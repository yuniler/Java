package atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 *  Lambda
 *      左边 形参列表
 *      右边 Lambda方法体
 * Lambda的形参类型可以省(类型推断),if lambda形参列表只有一个参数，一对()可省.还有{}
 * Lambda可以用一对{}包裹,if Lambda体只有一条执行语句 （可能是return)，也可以省略{}
 *
 *  4.Lambda的实质是一个函数式接口；；；如 runnable
 * 5.如果一个接口中，只声明了一个抽象方法，我们称作函数式接口
 *
 * @author sun
 * @create 2020-10-26 21:11
 *
 * Lambda操作符
 */
public class LambdaTest1 {


    @Test
    public void test1(){
        //语法格式1————————
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京");
            }
        };//之所以加;--是因为，这不是一个方法而是一个语句
        r1.run();


        Runnable r2 = () -> System.out.println("我爱北京烤鸭");
        r2.run();

    }
    @Test
    public void test2(){


        //语法格式二：Lambda需要一个参数，但没有返回值
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("谎言和誓言的最大区别是什么");


        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("一个听的人当真,一个说的人当真");
    }

    //语法类型三：类型推断：基本数据类型可省
    @Test
    public void test3(){

        Consumer<String> con1= (String s) -> System.out.println(s);
        con1.accept("一个听的人当真,一个说的人当真");

        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("一个听的人当真,一个说的人当真");

    }
    @Test
    public void test4(){

        ArrayList<String> list = new ArrayList<>();
        int[] arr= {1,2,3};
    }

    //类型4：Lambda若只有一个参数,可以将()省略
    @Test
    public void test5(){
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("一个听的人当真,一个说的人当真");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("一个听的人当真,一个说的人当真");
    }

    @Test
    public void test6(){

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        com.compare(31,23);


        Comparator<Integer> com1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        com1.compare(31,23);
    }
    //Lambda中只有一条语句，把{}省略,{}省了之后return也要省
    @Test
    public void test7(){

        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        com1.compare(83,52);

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        com2.compare(83,52);
    }

}
