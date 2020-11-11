package com.atguigu.linkedlist;

/**
 * 环形单链表
 * n表几个，k表从第几个开始，m表数几下
 *
 * @author sun
 * @create 2020-11-11 17:33
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);

    }
}

/*
循环单向链表
 */
class CircleSingleLinkedList {
    //初始化first节点，为空，没有编号
    //初始化环形链表的头结点
    private Boy first = null;

    //添加操作 ： 添加一个小孩，构成环形单链表
    public void addBoy(int nums) {
        if (nums < 1) {//nums判断
            System.out.println("nums值不对，请重新输入");
            return;
        }

        Boy curBoy = null;//赋值指针，帮助构建
        //for循环帮助构建
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //判断是否为第一个小孩，第一个小孩不能动，其curBoy就是代替他来完成
            if (i == 1) {
                first = boy;//boy加入
                first.setNext(boy);//构成环状
                curBoy = first;//替代指针。curBoy指向第一个小孩
            } else {//第二个开始
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;//替代指针
            }
        }
    }

    /*
    遍历当前链表
     */
    public void showBoy() {
        //非空判断
        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }

        //first 不能动，需引入cur代替完成
        Boy curBoy = first;
        while (true) {
            //拿编号
            System.out.printf("小孩的编号为%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {//遍历终止条件,说明已经完成遍历
                break;
            }
            curBoy = curBoy.getNext();//curBoy向后移动
        }
    }

    /**
     * @param startNo  从第几个小孩开始数
     * @param countNum 表数几下
     * @param nums     表最初有几个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据效验
        if (first == null || startNo < 1 || startNo > nums) {
            return;
        }
        //创建赋值指针
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first){//说明help指向小孩最后的节点。环的第一个
                break;
            }
            helper = helper.getNext();
        }
        //让小孩报数，先让first 和helper 移动 startNo - 1;从第几个开始数--这是一个前提条件，没有
        for (int j = 0; j < startNo - 1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }


        while (true){
            //相遇，遍历到尾
            if (first == helper){//圈中只有一个节点
                break;
            }
            //当小孩报数，让first和helper 移动countNum - 1
            for (int j = 0;j < countNum - 1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的就是要出圈的节点
            System.out.printf("出圈的节点号为%d\n",first.getNo());

            //出圈操作
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("留圈的节点号%d", helper.getNo());
    }
}

/*
创建Boy类，表示一个节点
 */
class Boy {

    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
