package atguigu.java2;

/**
 * @author sun
 * @create 2020-10-18 20:21
 */
public class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //没有重写equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    //出现hashCode才可以让equals()有效
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //需重写compareTo

//    @Override
//    public int compareTo(Object obj){
//        if(obj instanceof User){
//            User user = (User)obj;
//            int user = this.name.compareTo((user.name);
//                if(compareTo != null){
//                    return user;
//    }else{
//                    return Integer.compare(this.age,user.age);
//    }
//        }else{
//            throw new RuntimeException("输入类型异常");
//        }
//    }
}
