package atguigu.java1;

import java.lang.annotation.*;

/**
 * @author sun
 * @create 2020-10-17 15:21
 */
@Inherited
@Target({ElementType.FIELD,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})//TYPE
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    //属性
    String value() default "hello";
}
