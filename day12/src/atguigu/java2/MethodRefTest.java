package atguigu.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Lambda使用情景--》当传递Lambda体的操作，已经有了实现方法，即可以使用方法引用
 *
 *
 *
 *
 * @author sun
 * @create 2020-10-27 17:38
 */
public class MethodRefTest {

    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("************");


        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijin");
    }

    @Test
    public void test2(){

        Employee emp = new Employee(1001,"Tom",19,5000);
        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        Supplier<String> sup1 = emp::getName;
        System.out.println(sup1.get());


    }

    //静态方法，用  类:: 静态方法
    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(31, 21));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(21, 53));
    }
    //函数型 R apply()
    @Test
    public void test4(){

        Function<Double,Long> fun = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double,Long> fun1 = aDouble -> Math.round(aDouble);
        System.out.println(fun1);

        Function<Double,Long> fun2 = Math::round;
        System.out.println(fun2.apply(32.2));

    }
}
