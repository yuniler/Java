package atguigu.exer1;

import java.util.List;

/**
 * @author sun
 * @create 2020-10-22 20:50
 */
public class DAOTest {

    public static void main(String[] args) {

        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,35,"昆凌"));
        dao.save("1003",new User(1003,36,"蔡依林"));


        dao.update("1003",new User(1003,36,"sasd"));

        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}

