package com.atguigu.stack;

/**
 * @author sun
 * @create 2020-11-14 13:45
 */
public class Caluculator {
    public static void main(String[] args) {
        //根据思路，计算
        String expression = "30+2*6-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//每次扫描得到的char放进ch
        String keepNum = "";//用于拼接多位数
        //开始扫描expression
        while(true){
            //得到ch的expression的每一个字符
            ch = expression.substring(index,index + 1).charAt(0);//只取一个
            //判断ch是什么，做相应处理
            if (operStack.isOper(ch)){//是运算符
                //判断符号栈是否空
                if (!operStack.isEmpty()){
                    //做处理,如果符号栈中有操作符，进行比较，如果小于，等于符号栈中的操作符,从数栈中pop两个值
                    //从符号栈中pop()一个操作符，进行运算，得到结果，结果入数栈，符号入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        //把新运算符入符号栈
                        operStack.push(ch);
                    }else{
                        //当前符号大于符号栈
                        operStack.push(ch);
                    }
                }else{
                    //为空，直接入栈
                    operStack.push(ch);//1+3
                }
            }else{//如果是数字，直接入数栈
//                numStack.push(ch - 48);//此时的ch为'1'
                //多位数时：俩位和俩位以上
                //处理数时，需要向expression的表达式的index，后看一位，数就继续扫描，符号就计算
                keepNum += ch;

                //此刻没有考虑index+1为最后一位时的情况
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                        //注意看最后一位                               //前闭后开
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //最后一位为运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的keepNum清空
                        keepNum = "";

                    }
                }



            }
            //让index + 1,判断是否扫瞄到expression最后
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //表达式扫描完成，顺序从符号栈和数栈pop相应的数和符号，并且运行
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);//入栈

        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression,res2);

    }
}

/*
定义一个ArrayStack表示，使用数组
 */
class ArrayStack2{
    private int maxSize;
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，-1初始化

    //构造器
    public ArrayStack2(int maxSize){
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

    //增加一个方法，返回当前栈顶的值，但不是真正的pop()，只是偷看一眼栈顶
    public int peek(){
        return stack[top];
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

    //栈中增加操作
    //返回运算符的优先级，优先级程序员来定，优先级使用数字
    //数字越大，优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;//现在只定义*/+-
        }
    }

    //判断是否为运算符
    public boolean isOper(int val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//存放结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                 break;
            case '*':
                res = num1 * num2;
                break;
            case  '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}
