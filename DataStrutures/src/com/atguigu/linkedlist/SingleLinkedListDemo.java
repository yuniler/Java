package com.atguigu.linkedlist;

/**
 *
 *          Xxx.next 它仍然指的是
 * @author sun
 * @create 2020-11-07 17:08
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


        SingLinkedList singLinkedList = new SingLinkedList();
        //加入
//        singLinkedList.add(hero1);
//        singLinkedList.add(hero2);
//        singLinkedList.add(hero3);
//        singLinkedList.add(hero4);

        //按照编号的顺序加入
        singLinkedList.addByOrder(hero1);
        singLinkedList.addByOrder(hero3);
        singLinkedList.addByOrder(hero2);
        singLinkedList.addByOrder(hero4);
        singLinkedList.addByOrder(hero3);


        //显示-->遍历
        singLinkedList.list();
    }
}

//定义SingLinkedList,管理我们的英雄
class SingLinkedList{

    //初始化头结点，头结点不用动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    /*
    添加节点到单链表
    思路：不考虑编号顺序
    1.找到当前节点的最后节点
    2.将最后节点的next指向新节点
     */

    public void add(HeroNode heroNode){
        //头结点不能动，引入辅助节点temp

        HeroNode temp = head;

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
        temp.next = heroNode;
    }

    /**
     * 第二种方式去添加
     *      根据排名添加英雄
     *      如果有这个位置，添加失败
     */

    public void addByOrder(HeroNode heroNode){
        //头结点不能动，引入temp，辅助变量
        //因为单链表我们找到temp位于添加位置的   前  一个位置   ，
        HeroNode temp = head;
        boolean flag = false;

        while (true){

            //说明temp已在链表的尾部，添加位置也无法连接
            if (temp.next == null){
                break;
            }

            //说明新添加的元素，需要位于，temp 和temp.next 之间
            if (temp.next.no > heroNode.no){//从temp后插入
                break;
            } else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            //都不满足，仍然需要向下遍历
            temp = temp.next;

        }
        if (flag){
            System.out.printf("准备插入的英雄已存在编号为%d",heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;//  此时为什么指的是指，而是指的是next??

        }


    }


    /**
     * 遍历链表
     */
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //头结点不能动，需辅助节点来遍历
        HeroNode temp = head.next;

        while(true){
            //判断链表是否最后
            if (temp == null){
                break;
            }

            //打印
            System.out.println(temp);
            //接着下一个，后移
            temp = temp.next;
        }


    }




}

class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public  HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }


    //为了显示方法，重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
