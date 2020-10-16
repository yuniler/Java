package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sun
 * @create 2020-10-16 16:45
 */
public class CompareTest {

    /**
     * Comparable接口的使用
     * 1.String ,包装类实现了Comparable接口，重写compareTo(obj)方法，给出比较对象
     * 2.String,包装类实现compareTo()接口后，进行从小到大的排序
     * 3.重写规则
     * > 为正
     * <
     * =
     *
     * 4.对于自定义类进行排序，使用自定义类实现Comparable接口进行排序，重写方法--指明该如何做
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "CC", "KK", "BB"};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("dellMouse",43);
        arr[1] = new Goods("xiaomiMouse",19);
        arr[2] = new Goods("huaweiMouse",60);
        arr[3] = new Goods("lenovo",34);
        arr[4] = new Goods("huaweiMouse",70);
        //产品名称从低到高，价格从高到低
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("请重新输入");
            }
        });//sort-->排序，对象排序
        System.out.println(Arrays.toString(arr));

    }
    /**
     * Comparator接口：定制排序
     *1.背景
     * 当元素类型没有实现java.lang.comparable接口但不方便修改代码，实现java.
     * 或者实现java.lang.Comparable接口排序规则不适合当前操作时，使用Comparator的对象操作
     *
     *
     */

    @Test
    public void test3(){
        String[] arr = new String[]{"AA", "CC", "KK", "BB"};

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //将字符串从小到大排序

                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("你输入的类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));

    }

}

