package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author sun
 * @create 2020-10-25 17:27
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;


    private void breath(){

        System.out.println("生物呼吸");
    }
    public void eat(){

        System.out.println("生物可以吃东西");
    }
}
