package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author sun
 * @create 2020-11-06 14:37
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);//有效数据最大是3
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop) {

            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列的头数据");
            key = scanner.next().charAt(0);

            switch (key) {
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
                        System.out.printf("取出的数据%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看头
                    try {
                        int res = queue.headQueue();
                        System.out.printf("查看的头数据为%d\n", res);
                    } catch (Exception e) {
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
    }
}

class CircleArray {
    private int maxSize;
    //front此时执行队列的第一个元素，也就是，arr[front]的初始值为0
    private int front;
    //rear此时为队列的最后一个元素的后一个位置，空一个空间，arr[rear]=0
    private int rear;//我是这么理解：其实就是最后一个元素本身rear + 1表示最后一个元素的后一个位置
    private int[] arr;

    public CircleArray(int circleMaxSize) {
        maxSize = circleMaxSize;
        arr = new int[maxSize];
    }

    //判断队列已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;//结束
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列为空，无法取出");
        }
        //front值不变，只是位置变了。留出位置
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出");
            return;
        }

        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    //有效元素的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出");
        }
        return arr[front];
    }

}