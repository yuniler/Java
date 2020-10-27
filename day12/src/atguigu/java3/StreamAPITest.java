package atguigu.java3;

import atguigu.java2.Employee;
import atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * StreamAPI通过对套API可以对内存中的数据进行过滤，排序，归纳
 * 类似于sql对数据库的操作
 * @author sun
 * @create 2020-10-27 19:56
 */
public class StreamAPITest {
    //1.创建Stream的方式一:通过集合

    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();


        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();


    }
    //方式二： 通过数组
    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5};
        IntStream intStream = Arrays.stream(arr);
        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] employees = new Employee[]{e1,e2};
        Stream<Employee> employeeStream = Arrays.stream(employees);




    }
    //创建方式三: stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5);


    }

    //创建方式四：无线流
    @Test
    public void test4(){

        //带上limit(), 才会有终止，这是无限流
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
    }






}
