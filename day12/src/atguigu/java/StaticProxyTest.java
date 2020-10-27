package atguigu.java;

/**
 * 使用反射之前
 *
 * @author sun
 * @create 2020-10-26 17:47
 */


interface ClothFactory{
    void produceCloth();
}

class ProxyProduceCloth implements ClothFactory{

    private ClothFactory factory;

    public ProxyProduceCloth(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        //将被代理类实例化
        System.out.println("生产前的准备工作");

        //代理类
        factory.produceCloth();


        System.out.println("生产结束的收尾工作。。。");
    }
}
class NikeProduceCloth implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike = new NikeProduceCloth();//将子类的对象赋给父类的引用

        ProxyProduceCloth proxyProduceCloth = new ProxyProduceCloth(nike);
        proxyProduceCloth.produceCloth();

    }
}
