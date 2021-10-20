package com.garen.sort.quickSort;

import com.garen.util.ArrayUtil;

public class DutchFlapSort {
    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 10, 2, 4, 16, 8, 1, 17};
        dutchFlagSort1(arr, 9);
        ArrayUtil.printArray(arr);
        int[] arr1 = {9, 2, 5, 10, 2, 4, 16, 8, 1, 17};
        dutchFlagSort2(arr1, 9);
        ArrayUtil.printArray(arr1);
    }

    //给定一个数组， 一个 target 数
    //将数组中小于等于（<=） target 的数放在数组中 target 的左边，即小于区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    private static void dutchFlagSort1(int[] arr, int target) {
        int lessArea = -1;// 小于等于区， 剩下的是大于区
        for(int i=0; i < arr.length; i++){
            if(arr[i] <= target){
                swap(arr, i, ++lessArea);
            }
        }
    }

    //给定一个数组， 一个 target 数
    //将数组中小于（<） target 的数放在数组中 target 的左边，即小于区
    //将数组中等于（==） target 的数放在数组中小于区与大于区中间， 即中间区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    private static void dutchFlagSort2(int[] arr, int target) {
        int lessArea = -1;//小于区，下标从-1开始
        int greaterArea = arr.length;//大于区，下标从arr.length开始， 剩下的是中间区（即相等区）
        for (int i=0; i<arr.length;i++){
            if(i >= greaterArea){
                break;
            }
            if(arr[i] < target){
                swap(arr, i, ++lessArea);
            }else if(arr[i] > target){
                swap(arr, i, --greaterArea);
                i --;
            }
        }
    }


    private static void swap(int[] arr, int one, int another) {
        int temp = arr[one];
        arr[one] = arr[another];
        arr[another] = temp;
    }
}
