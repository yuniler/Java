package atguigu.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author sun
 * @create 2020-10-26 20:51
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京故宫");
            }
        };
        r1.run();


        System.out.println("************************");
        Runnable r2 = () -> System.out.println("我爱吃北京烤鸭");
        r2.run();

    }

    @Test
    public void test2(){


        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(19,21);
        System.out.println(compare1);



        System.out.println("************************");

        //Lambda写法
        Comparator<Integer> com2 = ((o1, o2) -> Integer.compare(o1,o2));
        int compare2 = com2.compare(31,19);
        System.out.println(compare2);

        //方法的引用
        Comparator<Integer> com3 = Integer ::compare;
        int compare3 = com3.compare(32,21);
        System.out.println(compare3);
        }
    }




