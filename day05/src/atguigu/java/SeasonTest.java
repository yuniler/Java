package atguigu.java;

/**
 * 枚举类
 *一。枚举类的使用
 * 1.枚举类的对象有有限多个，确定的，称为枚举
 * 2.定义一组常量建议使用
 * 3.如果枚举类只有一个对象，作为单例模式的实现方式
 *
 *
 * 二。如何定义
 * 一，JDK5.0之前，自定义
 * 二，JDK5.0，可以使用enum关键字定义
 *
 * 三 常用方法
 * values()
 * valueOf()
 * toString()
 *
 *
 * 四，enum关键字定义的枚举类实现接口
 * 1.实现接口，在enum类中实现抽象方法
 * 2.让枚举类对象分别实现
 * @author sun
 * @create 2020-10-17 10:44
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

    }

}
interface Info{
    void show();
}

class Season implements Info{

    //1.声明Season对象的属性的private，final
    private String seasonName;
    private String seasonDesc;

    //2.私有化构造器，给对象赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供枚举类的多个对象，并给对象属性赋值 public static final 的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");


    //获得枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他诉求
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("季节各不一样");
    }
}
