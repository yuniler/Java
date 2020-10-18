package atguigu.java1;

import java.util.ArrayList;

/**
 *
 *
 * 注解：  Annocation的使用
 *
 * 1.生成文档相关的注解
 * 2。编译时进行格式检查(JDK的三个基本注解)
 *      @Override:限定重写父类方法，注解只能用于方法
 *      @Deprecated:用于边上所修饰的元素(类。方法)已过时。结构危险
 *      @SuppressWarnings:抑制编译器警告
 *
 *
 * 自定义注解：参考@SuppressWarnings
 *      1.声明：@interface
 *      2.内部定义成员，通常使用value
 *      3.指定成员的默认值，使用default
 *      4.自定义注解没有成员(value)，表明只是一个表示
 *
 *      自定义注解：使用反射才有意义
 *
 *元注解:
 * jdk提供4种元注解---元注解：对注解进行注解(解释)
 *
 * Retention:指定所修饰Annotation的生命周期 ： SOURCE\CLASS\RUNTIME
 *          只有声明为RUNTIME注解才可以反射获取
 *
 *Target  用于指定被修饰 Annotation能用于修饰那些元素
 * Documented：表示修饰的注解在被javadoc解析时，保留下来
 * Inherited：被修饰的Annotation有继承性
 *
 *
 * 可重复注解：
 *
 * 在MyAnnotation声明@Repeatable,成员值为MyAnnotation.class
 * MyAnnotation的Target和Retention和MyAnnotation相同
 *
 *
 * 重复注解
 *      Type.TYPE_PARAMETER 表示该注解可以写在类型变量的声明语句中(泛型)
 *      Type.TYOE_UES  表示该注解写在使用类型的任何语句中
 *
 *
 *
 *
 * .
 * @author sun
 * @create 2020-10-17 15:01
 */
public class AnnotationTest {
}

//@MyAnnotation("h")//可以调v默认alue也可以重新输入
class Person{

}
class Generic< @MyAnnotation T>{
    public void show() throws  @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num =(@MyAnnotation int) 10L;
    }
}
