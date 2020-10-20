package com.atguigu.exer1;

/**
 *
 *
 *
 *
 *
 * @author sun
 * @create 2020-10-19 9:31
 */
public class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate birthDay;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthDay) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
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

    public MyDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(MyDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                '}';
    }


    //按照 name 排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("输入类型不一致");
    }
}
