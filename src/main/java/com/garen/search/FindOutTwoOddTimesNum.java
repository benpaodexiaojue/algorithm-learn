package com.garen.search;


public class FindOutTwoOddTimesNum {

   public static void main(String[] args){
       //题目：
       // 一个数组中有两种数出现了奇数次， 其他数出现偶数次，
       // 找出这两种出现奇数次的数

       int[] arr = {1, 3, 2, 4, 3, 6, 1, 4, 5, 4, 3, 5, 3, 4, 6, 5};
       int[] result = searchTwoOddTimesNum(arr);
       System.out.println(result[0]+" "+result[1]);
   }

    private static int[] searchTwoOddTimesNum(int[] arr) {
        int[] result = {0,0};
        //temp 与数组中所有的数异或之后，
        //得到的结果是所求两个数的异或结果 temp
        //此时 temp 的值的二进制的位为 1 的位，
        //其所求两种数相应的位必不相同，
        //故可以以这个位的值将数组的数分为两组（0为一组， 1为一组）
        //然后分别用这两组数异或， 即可得出结果
        int temp = 0;
        for(int i=0; i<arr.length; i++){
            temp ^= arr[i];
        }
        int temp1 = temp & (-temp);
        for(int i=0; i<arr.length; i++){
            if((temp1 & arr[i]) == 0){
                result[0] ^= arr[i];
            }else {
                result[1] ^= arr[i];
            }
        }
        return result;
    }
}
