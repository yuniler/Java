package com.atguigu.java1;

/**
 * @author sun
 * @create 2020-10-25 17:27
 */
@MyAnnotation(value = "hi")//通过反射也可以获取注解
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    public String name;
    int age;
    public int id;

    public Person() {
    }

    ;

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    @MyAnnotation(value = "332")
    public String display(String interests,int age) {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
