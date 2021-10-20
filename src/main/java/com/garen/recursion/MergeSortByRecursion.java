package com.garen.recursion;

import com.garen.util.ArrayUtil;

public class MergeSortByRecursion {

    public static void main(String[] args) {
        int[] arr = {2,4,1,2,6,4,8,3,9,2};
        ArrayUtil.printArray(arr);
        mergeSort(arr);
        ArrayUtil.printArray(arr);
    }

    private static void mergeSort(int[] arr) {
        if(arr == null || arr.length ==0){
            return;
        }
        int left = 0;
        int right = arr.length-1;
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int left, int right) {
        if(left == right){
            return;
        }
        int mid = left + ((right - left) >>1);
        merge(arr, left, mid);
        merge(arr, mid+1, right);
        int[] helpArr = new int[right - left +1];
        int lp = left;
        int rp = mid +1;
        int i =0;
        while (lp <= mid && rp <= right){
            helpArr[i++] = arr[lp] < arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid){
            helpArr[i++] = arr[lp++];
        }
        while (rp <= right){
            helpArr[i++] = arr[rp++];
        }
        for (int j=0; j<helpArr.length; j++){
            arr[left + j] = helpArr[j];
        }
    }

}
