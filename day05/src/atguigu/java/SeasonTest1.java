package atguigu.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承java.lang.Enum类
 * 例如：不调用toString()。出现SUMMUE，使用自己调用的。。
 * @author sun
 * @create 2020-10-17 12:26
 */
public class SeasonTest1 {

    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        //1.方法1、toString()
        System.out.println(summer.toString());

        //values--调用值
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();

        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);


        }

        //valueOf(String objName)，返回枚举类对象名是objName对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

    }


}
interface Info1{
    void show();
}
enum Season1 implements Info1{
    //提供当前枚举类的对象，多个对象之间用","隔开。最后使用;隔开
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天夏天很冰霜");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天秋天很凉爽");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天冬天很冷啊");
        }
    };

    //1.声明Season对象的属性的private，final
    private String seasonName;
    private String seasonDesc;

    //2.私有化构造器，给对象赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供枚举类的多个对象，并给对象属性赋值 public static final 的


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
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}