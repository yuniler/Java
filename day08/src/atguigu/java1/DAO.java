package atguigu.java1;

import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 17:40
 *
 *
 * DAO：data(base) access object
 */
public class DAO<T> {

    //添加一条数据(方法）
    public void add(T t){

    }
    //删除
    public boolean remove(int index){
        return false;

    }
    //修改
    public void updata(int index,T t){

    }

    //查单条
    public T getIndex(int index){
        return null;
    }
    //查多条
    public List<T> getForList(int index){
        return null;
    }

    //泛型方法
    //获取表中一共有多少员工?获取最大员工的入职时间
    public <E> E getValue(){
        return null;
    }
}
