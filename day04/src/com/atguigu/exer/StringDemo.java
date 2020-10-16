package com.atguigu.exer;

import org.junit.Test;

/**
 * @author sun
 * @create 2020-10-16 8:53
 */
public class StringDemo<pub> {
    /**
     * 方式一：for遍历
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */

    public String reverse(String str,int startIndex,int endIndex){
        if (str != null){
            char[] arr = str.toCharArray();//String转char[]
            for(int x = startIndex, y = endIndex;x <= y;x++,y--){
                char temp = arr[x];//char去接收变量
                arr[x] = arr[y];
                arr[y] = temp;
            }

            return new String(arr);

        }
        return null;
    }

    /**
     * 方式二：拼接
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */

    public String reverse1(String str, int startIndex,int endIndex){

        if (str != null){

            //拼接
            String reserveStr = str.substring(0,startIndex);
            for (int i = endIndex;i >= startIndex;i--){
                reserveStr += str.charAt(i);

            }
            reserveStr += str.substring(endIndex + 1);

            return reserveStr;
        }
        return null;

    }
    public String reverse3(String str,int startIndex,int endIndex){
        if (str != null){

            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0,startIndex));

            for (int i = endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));//不用在去+=，重复去删。。。
            }
            builder.append(str.substring(endIndex + 1));

            return builder.toString();
        }

        return null;



    }
    @Test
    public void reverseTest() {
        String str = "ab123fg";
        String rev = reverse3(str, 2, 5);
        System.out.println(rev);
    }

}
