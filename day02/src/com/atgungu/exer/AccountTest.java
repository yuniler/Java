package com.atgungu.exer;

/**
 * @author sun
 * @create 2020-10-13 11:55
 */


class Account{

    private double balance;

    public Account() {

    }
    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt){
        if (amt >= 0){
            balance += amt;//balance 有线程不安全

            //此处有线程不安全
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 存钱成功，余额为：" + balance);
        }
    }


}

class Customer extends Thread{

    private Account acct;

    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);//一次一千
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();//this 此时共用一个acct一个Account
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
