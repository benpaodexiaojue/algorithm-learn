package com.garen.recursion;


//递归实现求一个数组中的最大值
public class MaxNumByRecursion {

    public static  void main(String[] args){
        int[] arr = {3,5,2,4,3,43,43,56,4,34,34,2,4,4};
        int max = maxNum(arr, 0, arr.length-1);
        System.out.println(max);

    }

    private static int maxNum(int[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int leftMax = maxNum(arr, 0, left);
        int rightMax = maxNum(arr, left+1, right);
        return Math.max(leftMax, rightMax);
    }
}
