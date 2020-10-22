package atguigu.exer;

/**
 * @author sun
 * @create 2020-10-19 9:29
 */
public class MyDate implements Comparable<MyDate>{

    int year;
    int month;
    int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int compareTo(MyDate m) {
        int minusYear = this.getYear() - m.getYear();
        if (minusYear != 0){

            return minusYear;
        }
        int minusMouth = this.getMonth() - m.getMonth();
        if (minusMouth != 0){
            return minusMouth;
        }
            return this.getDay() - m.getDay();


    }
}
