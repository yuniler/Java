package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author sun
 * @create 2020-11-03 19:50
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        //测试

        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while(loop){

            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列的头数据");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看头
                    try{
                        int res = queue.headQueue();
                        System.out.printf("查看的头数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//初始化数组,用于存放数组，模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头，front是指向队列头的前一个位置
        rear = -1;//指向队列尾的数据(即队列的最后一个数据)
    }

    //判断队列已满
    public boolean isFull(){
        return rear == maxSize - 1;//在队列中maxSize为最后一个元素。0-maxSize-1
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列(初始化)
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法添加数据");
            return;//结束
        }
        rear++;//让rear后移
        arr[rear] = n;

    }

    //取出数据从队列中
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空，无法取出");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据(遍历)
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，无法取出");
            return;
        }

        for (int i = 0;i < arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    //显示队列的头元素,而不是取出
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }
        return arr[front + 1];
    }


}
