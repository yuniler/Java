package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sun
 * @create 2020-11-16 19:28
 */
public class PolandNotation {
    public static void main(String[] args) throws Exception {

        //逆波兰表达式，空格隔开
        String suffexExpression = "30 4 + 5 * 6 -";
        //思路
        //1.先将 3 4 + 5 * 6 - 放入ArrayList中
        //2.将ArrayList 传递一个方法并遍历，配合栈完成

        List<String> list = getListString(suffexExpression);
        System.out.println("rpnList:" + list);

        int res = calculate(list);
        System.out.println("计算的结果是：" + res);

    }


    //将波兰表达式，依次将数据和运算符，放入ArrayList
    public static List<String> getListString(String suffexExpression){
        //将分割
        String[] split = suffexExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split){
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     *
     * 1.从左到右扫描，将3,4压入堆栈
     * 2.遇到+运算符，弹出4,3，计算，得出7，入栈
     * 3.将5入栈
     * 4.接下来是x运算符，弹出5,7，计算5*7，得35，再入栈
     * 5.将6入栈
     * 6.最后是-运算符，计算35-6，得出结果入栈
     */
    public static int calculate(List<String> ls) throws Exception {
        //创建栈，一个就可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item : ls){
            //此时表正泽表达式出的值
            if (item.matches("\\d+")){//匹配多位数
                stack.push(item);
            }else {
                //pop()俩个数，入栈运算
                //注意顺序已经编号
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new Exception("输入的操作符有误");
                }
                //把res入栈
                stack.push(res + "");//将整形转为字符串型
            }
        }
        return Integer.parseInt(stack.pop());//
     }


}
