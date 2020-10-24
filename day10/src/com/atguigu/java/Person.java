package com.atguigu.java;

import java.io.Serializable;

/**
 * 需要实现接口--可序列化接口
 * 所有对象都需要有Serializable接口，基本数据类型内部已经实现了可序列化接口
 * 不能序列化的属性用，static  .transient修饰
 * @author sun
 * @create 2020-10-24 10:21
 */
public class Person implements Serializable {//可序列化接口

    public static final long serialVersionUID = 312512131L;
    String name;
    int age;
    static Account acc;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
class Account implements Serializable{//其自定义类也要可实例化
    public static final long serialVersionUID = 312531L;
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
