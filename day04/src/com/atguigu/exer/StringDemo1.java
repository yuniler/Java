package com.atguigu.exer;

import org.junit.Test;

/**
 * 获取sub在main里出现的次数
 * @author sun
 * @create 2020-10-16 10:37
 */
public class StringDemo1 {

    public int getCount(String mainStr,String subStr){

        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;

        if (mainLength >= subLength){

            //方法一
//            while ((index = mainStr.indexOf(subStr)) != -1){//找到了
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//
//
//            }
            //方法二
            while((index = mainStr.indexOf(subStr,index))!= -1){
                count++;
                index += subLength;
            }
            return count;
        }else{
            return 0;
        }



    }
    @Test
    public void testGetCount(){
        String mainStr = "abbajsdasdjaslwkdakdabkw";
        String subStr = "ab";
        int count = getCount(mainStr,subStr);
        System.out.println(count);

    }

}
