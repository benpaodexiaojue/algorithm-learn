package com.garen.search;

public class FindOutOnlyOneOddTimesNum {

   public static void main(String[] args){
       //题目：
       // 一个数组中有一种数出现了奇数次， 其他数出现偶数次，
       // 找出这个出现奇数次的数

       int[] arr = {1,3,2,4,6,3,2,1,4,5,4,3,5,3,4, 6, 5};
       int result = searchOnlyOneOddTimesNum(arr);
       System.out.println(result == 5);
   }

    private static int searchOnlyOneOddTimesNum(int[] arr) {
        int result = 0;
        for(int i=0; i<arr.length; i++){
            result ^= arr[i];
        }
        return result;
    }


}
