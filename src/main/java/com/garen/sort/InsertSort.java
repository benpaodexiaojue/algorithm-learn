package com.garen.sort;

import com.garen.util.ArrayUtil;

import java.util.Arrays;


public class InsertSort {


    public static void main(String[] args){

        int count = 10;
        while(count > 0){
            int[] arr = ArrayUtil.creatArray(100, 10000);
            int[] copyArray = ArrayUtil.copyArray(arr);
            insertSort(arr);
            Arrays.sort(copyArray);
            ArrayUtil.printArray(arr);
            ArrayUtil.printArray(copyArray);
            if(!ArrayUtil.equals(arr, copyArray)){
                return;
            }
            count --;
        }
        System.out.println("Success!!!!!!!!!!");
    }

    private static void insertSort(int[] arr) {
        if(arr == null || arr.length <2){
            return;
        }
        for(int i=1; i< arr.length; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[j] > arr[j+1]){
                    swap(arr, j , j+ 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tem = arr[j];
        arr[j] = arr[i];
        arr[i] = tem;
    }
}
