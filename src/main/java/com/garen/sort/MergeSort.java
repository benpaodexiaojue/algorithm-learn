package com.garen.sort;

import com.garen.util.ArrayUtil;

public class MergeSort {

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
        int n = arr.length;
        int stepLen = 1;//左右归并的步长
        while (stepLen < n){
            int left =0;
            while (left < n){
                if(stepLen > (n - left)){ // 剩余的不够左边的步长，则不再继续下去
                    break;
                }
                int mid = left + stepLen -1;
                int right = mid + Math.min(stepLen, n - mid -1); //剩余的如果够一个步长，则右边的用步长的长度，不够就将剩余的全部放到右边
                merge(arr, left, mid, right);//归并排序
                left = right +1; // left 移到 right 的后一位
            }
            stepLen = stepLen << 1;
        }

    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] helpArr = new int[right-left+1];
        int lp = left;
        int rp = mid +1;
        int i = 0;
        while (lp <= mid && rp <= right){ // 左指针移到 mid 停止， 右指针移到 right 停止
            if(arr[lp] < arr[rp]){//左边的数小，将左边的数放到 helpArr, 左边指针 lp+1
                helpArr[i] = arr[lp];
                lp ++;
            }else{ //右边的数小，将右边的数放到 helpArr, 右边指针 rp+1
                helpArr[i] = arr[rp];
                rp ++;
            }
            i++; //helpArr 指针 +1
        }
        //接下来将剩余没有归并的copy到 helpArr 后面
        while (lp <= mid){
            helpArr[i++] =arr[lp++];
        }
        while (rp <= right){
            helpArr[i++] =arr[rp++];
        }
        //最后将 helpArr copy 到 arr 的对应段中
        for(int j=0; j < helpArr.length; j++){
            arr[left + j] = helpArr[j];
        }
    };
}
