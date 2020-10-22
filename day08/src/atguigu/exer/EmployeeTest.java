package atguigu.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，将对象放入TreeSet集合中，分别排序，输出
 *
 * 1.使用Employee实现Comparable接口，按name排
 * 2.创建TreeSet传入Comparator对象，按生日排
 *
 *
 * @author sun
 * @create 2020-10-19 9:33
 */
public class EmployeeTest {


    //2.自定义排序
    @Test
    public void test2(){

        //按照年龄比较。由年-月-日
        TreeSet<Employee> set = new TreeSet(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthDay();
                MyDate b2 = o2.getBirthDay();

                return b1.compareTo(b2);

            }
            //只使用一次，调一次

            //使用泛型之前
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee){
//                    Employee e1 = (Employee)o1;
//                    Employee e2 = (Employee)o2;
//
//                    MyDate b1 = e1.getBirthDay();
//                    MyDate b2 = e2.getBirthDay();
//
//                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if (minusYear != 0){
//                        return minusYear;
//                    }
//
//                    //如果年一样，比较月
//                    int minusMouth = b1.getMonth() - b2.getMonth();
//                    if (minusMouth != 0){
//                        return minusMouth;
//                    }
//                    //比较天
//                    return b1.getDay() - b2.getDay();
//
//
//
//
//
//                }
//                throw new RuntimeException("输入的类型不一样");
//            }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1964,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //1.自然排序
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<>();


        Employee e1 = new Employee("liudehua",55,new MyDate(1964,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        //iterator 调入set方法
        Iterator<Employee> iterator = set.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);

        }
    }
}
