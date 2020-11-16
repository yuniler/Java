package com.atguigu.stack;

import java.util.Scanner;

/**
 * @author sun
 * @create 2020-11-12 15:00
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){

            System.out.println("show:显示栈的操作");
            System.out.println("exit:退出栈");
            System.out.println("push:入栈,添加操作");
            System.out.println("pop:添加操作");
            key = scanner.next();//对输入的key进行判断

            switch (key){
                case "show":
                    stack.list();
                    break;
                case  "push":
                    System.out.println("请输入入栈值");
                    int value = scanner.nextInt();//将输入的值入栈
                    stack.push(value);
                    break;
                case "pop":
                    System.out.println("输入出栈的值");
                    //将异常捕获
                    try{
                        int res = stack.pop();
                        System.out.printf("输出的值为%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;

                default:
                    break;
            }
        }
        System.out.println("程序已退出");

    }
}

/*
定义一个ArrayStack表示，使用数组
 */
class ArrayStack{
    private int maxSize;
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，-1初始化

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;//记住是数组
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈,栈顶元素返回
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有元素");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈，遍历栈(遍历),遍历时从栈顶返回元素
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有元素");
        }
        for (int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}