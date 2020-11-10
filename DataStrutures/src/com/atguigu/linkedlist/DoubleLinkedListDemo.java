package com.atguigu.linkedlist;

/**
 * @author sun
 * @create 2020-11-10 18:26
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {


        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        System.out.println("添加前");
        doubleLinkedList.list();

        System.out.println("更改后");
        //修改后
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.updata(newHeroNode);
        doubleLinkedList.list();
        System.out.println("修改后");

        System.out.println("删除后");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}


/*
创建一个双向链表的类
 */

class DoubleLinkedList{

    //初始化头结点
    HeroNode2 head = new HeroNode2(0,"","");

    //返回头结点
    public HeroNode2 getHeroNode2(){
        return head;
    }

    //遍历双向链表的方法
    public void list(){

        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，引入新变量
        HeroNode2 temp = head.next;
        while (true){
            //判断链表是否到了最后
            if (temp == null){
                return;
            }
            //输出节点信息
            System.out.println(temp);
            //持续遍历
            temp = temp.next;

        }
    }

    //没有改变
    public void updata(HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表为空~");
            return;
        }

        //头结点不能动，引入temp，辅助变量.temp也是值
        HeroNode2 temp = head;
        boolean flag = false;//表明是否找到该节点
        while(true){
            if (head == null){
                //"链表已经遍历结束！"
                break;
            }
            //说明找到
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }

            temp = temp.next;//链表后移，遍历条件
        }

        //根据flag，判断是否找到修改的节点
        if (flag) {//此时true
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else { // 没有找到时
            System.out.printf("没有找到编号为%d的节点\n",newHeroNode.no);
        }
    }

    /**
     * delete操作
     */
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        /**
         * 特别注意,单链表找到temp为该节点的前一个节点，需要从头节点找，找头结点的下一个
         * 而双链表的temp为本身要删除的那个节点，本身head.next的节点
         */
        HeroNode2 temp = head.next;


        boolean flag = false;
        while (true){
            //链表到尾，此时为最后一个节点
            if (temp.next == null){
                break;
            }
            //表示找到---这里注意一下
            if (temp.no == no){//no就表示node了

                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {//设置flag找到。。了
//            temp.next = temp.next.next;//链表连接--》单链表
            temp.pre.next  = temp.next;

            //此句话有风险，假如删除的为最后一个节点,temp为当前节点，temp.next就已经为空了，再次指，就为空指针
            if (temp.next != null){//保证能拿到下一个节点，temp(为当前节点).next
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("没有找到删除的编号为%d的节点",no);
        }


    }

    public void add(HeroNode2 heroNode){
        //头结点不能动，引入辅助节点temp

        HeroNode2 temp = head;

        //遍历链表，找到最后
        while(true){

            if (temp.next == null){
                break;
            }
            //如果不为空,将temp后移
            temp = temp.next;
        }
        //退出while循环后，说明next指向链表的最后
        //将最后一个节点的next指向加入的值
//        temp.next = heroNode;
        temp.next = heroNode;
        heroNode.pre = temp;
    }
}


/*
定义HersNode，初始化
 */

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
