package com.atguigu.linkedlist;

import java.util.Stack;

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
        singLinkedList.add(hero1);
        singLinkedList.add(hero2);
        singLinkedList.add(hero3);
        singLinkedList.add(hero4);
        //反转前
        singLinkedList.list();
        System.out.println();

        System.out.println("测试逆序打印，没有改变链表结构");
        reversePrint(singLinkedList.getHead());

//        //反转后
//        //反转链表
//        reverseList(singLinkedList.getHead());
//        singLinkedList.list();


//        //按照编号的顺序加入
//        singLinkedList.addByOrder(hero1);
//        singLinkedList.addByOrder(hero3);
//        singLinkedList.addByOrder(hero2);
//        singLinkedList.addByOrder(hero4);
////
//        singLinkedList.list();
//
//        System.out.println("通过no修改后的");
//
//
////        //测试通过no
////        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~~");
////        singLinkedList.updata(newHeroNode);
//
//        singLinkedList.del(2);
//        singLinkedList.del(3);
//        singLinkedList.list();
//        //显示-->遍历
//
//
//        //测试有效节点的个数
//        System.out.println("有效节点的个数为" + getLength(singLinkedList.getHead()));
//
//        //倒数第k个节点测试
//        HeroNode res = findLastIndexNode( singLinkedList.getHead(),1);
//        System.out.println(res);

    }
    /*
    百度面试
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null){//链表为空
            return;
        }
        //创建栈，将元素压入
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        //依次压入
        while (cur != null){
            stack.push(cur);
            cur = cur.next;//循环条件
//            System.out.println("cur 当前值为" + cur);
        }
        //将stack的各个节点取出打印
        while (stack.size() > 0){
            System.out.println(stack.pop());//先人后出
        }


    }



    /*
    腾讯面试
    反转链表

     */
    public static void reverseList(HeroNode head){
        //当前链表为空，或者当前只有一个节点，无需返回
        if (head.next == null || head.next.next == null){
            return ;
        }

        //定义辅助变量
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来链表，每遍历一个将其取出，并放在新链表reverseHead的最前端
        while (cur != null){
            next = cur.next;//保存下一个节点
            cur.next = reverseHead.next;//每次放在reverseHead的最前端---加入连
            reverseHead.next = cur;//向后连新
            cur = next;
        }

        //将head.next = reverseHead.next最后一步，收尾
        head.next = reverseHead.next;

    }



    /*
    查找链表中倒数第k个节点[面试题]
    1.编写方法接收head.next节点 同时编入index
    2.index表示倒数第index节点
    3.第一次遍历得到长度
    4.得到size后，第二次遍历，我们遍历(size - index)个
    5.找到返回，没找到返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){

        if (head.next == null){
            return null;
        }
        //得到已知链表长度
        int size = getLength(head);
        //第二次遍历到size - index的位置，也就是倒数第k个
        //先校验,节点越界
        if (index <= 0 || index > size){
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index;i++){//3 --  3-1=2
            cur = cur.next;//向下遍历
        }
        return cur;
    }



    /**
     * 方法：获得单链表节点的个数 (如果是带头节点，吧计算头结点）
     * @param head
     */
    public static int getLength(HeroNode head){

        if (head.next == null){
            return 0;
        }

        int length = 0;
        //不要把头节点统计上了
        HeroNode cur = head.next;
        while (cur != null){//链表的尾部
            length++;
            cur = cur.next;
        }
        return length;
    }
}





//定义SingLinkedList,管理我们的英雄
class SingLinkedList{

    //初始化头结点，头结点不用动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");


    public HeroNode getHead() {
        return head;
    }




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
     * 修改节点信息，根据no编号来修改，no不能变
     */
    public void updata(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空~");
            return;
        }

        //头结点不能动，引入temp，辅助变量.temp也是值
        HeroNode temp = head;
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
            return;
        }

        HeroNode temp = head;
        boolean flag = false;
        while (true){
            //链表到尾，此时为最后一个节点
            if (temp.next == null){
                break;
            }
            //表示找到---这里注意一下
            if (temp.next.no == no){//no就表示node了

                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;//链表连接
        } else {
            System.out.printf("没有找到删除的编号为%d的节点",no);
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
