package atguigu.java;

import org.junit.Test;

import java.util.*;

/**JDK5.0之后
 * 注意泛型只能写入“类”
 * 想使用泛型底层必须也是泛型
 *
 * @author sun
 * @create 2020-10-21 17:15
 */
public class GenericTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(97);
        list.add(79);
        list.add(96);
        list.add(89);
        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list){
            //强转出现报错
            int StuSco = (Integer) score;
            System.out.println(StuSco);
        }
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();//编译时进行检查，保证数据安全
        list.add(97);
        list.add(79);
        list.add(96);
        list.add(89);

        //方式一
//        for (Integer score : list){
//            //避免强转
//            Integer stuSco= score;
//            System.out.println(stuSco);
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();//因为Iterator已经为Integer类型
        }

    }


    //集合中使用泛型
    @Test
    public void test3(){

        Map<String,Integer> map = new HashMap<>();


        //Map<String,Integer>决定了你添加的类型<"",...>;
        map.put("Tom",22);
        map.put("Jerry",17);
        map.put("Jack",25);

        //Entry是Map的内部接口
        Set<Map.Entry<String,Integer>> keySet = map.entrySet();//Map.Entry<>返回此映射中包含的映射关系的Set视图
        Iterator<Map.Entry<String, Integer>> iterator = keySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "--------"  + value);
        }
        


    }
}
