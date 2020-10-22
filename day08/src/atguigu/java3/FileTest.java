package atguigu.java3;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * @author sun
 * @create 2020-10-22 21:04
 */
public class FileTest {

    @Test
    public void test1(){

        File file1 = new File("hello.txt");
        File file2 = new File("D:\\atguigustudy\\day 系列\\code\\day08");
        File file3 = new File("D:\\atguigustudy","JavaSenior");
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){

        File file1 = new File("hello.txt");
        File file2 = new File("D:\\workspace_idea1\\io\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }
    @Test
    public void test3(){
        File file = new File("D:\\workspace_idea1\\JavaSenior");
        String[] list = file.list();
        for (String s : list){
            System.out.println(s);
        }
        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f);
        }
    }

    //file1.renameTo(file2)为例
    //要想保住返回true，需要file1在硬盘存在，file2不能在硬盘存在
    @Test
    public void test5(){

        File file1 = new File("hello.txt");
        File file2 = new File("D:\\workspace_idea1\\io\\hi.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }
}
