package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @author sun
 * @create 2020-11-10 17:54
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("Smith");
        stack.add("Tom");
        stack.add("Jerry");

        //出栈
        while (stack.size() > 0){
            String actor = stack.pop();//pop方法，将栈顶元素依次取出
            System.out.println(actor);

        }



    }
}
