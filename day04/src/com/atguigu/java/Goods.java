package com.atguigu.java;

/**
 * @author sun
 * @create 2020-10-16 17:11
 */
public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods(){

    }
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明如何排
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){//是不是一个商品

            Goods goods = (Goods)(o);
            if (this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return this.name.compareTo(goods.name);//相同了进行换属性再排
            }
            //方式二：
//            return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入类型错误");
    }






}
