package com.atgungu.java1;

/**
 * @author sun
 * @create 2020-10-13 9:51
 */
public class BankTest {
}


class Bank{

    private Bank(){

    }

    private static Bank instance = null;

    public static Bank getInstance(){
//        //方式1：效率稍差
//        synchronized(Bank.class);
//        if (instance == null){
//            instance = new Bank();
//        }
//        return instance;
   //2..效率较好---》双重检查。。双端检索
        if (instance == null){

            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();

                }
                return instance;
            }
        }
        return instance;
    }


}
