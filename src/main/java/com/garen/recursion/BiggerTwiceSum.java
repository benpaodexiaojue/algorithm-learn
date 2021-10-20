package com.garen.recursion;

import com.garen.util.ArrayUtil;


public class BiggerTwiceSum {

    public static void main(String[] args) {
        //题目： 找出一个数组中每个数，比其右边的数的两个都大的个数
        //如：{1 9 2 11 5 3}  9： 2 4 3;  11: 5 3-> 总个数为 5
        int[] arr = {1, 9, 2, 11, 4, 3, 1};
        int[] copyArr = ArrayUtil.copyArray(arr);
        int count = biggerTwiceSum(arr);
        int target = test(copyArr);

        System.out.println(count);
        System.out.println(target);
        System.out.println(target == count);
    }

    private static int test(int[] arr) {
        int count =0;
        for(int i =0; i<arr.length; i ++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i] > (arr[j] * 2)){
                    count ++;
                }
            }
        }
        return count;
    }

    private static int biggerTwiceSum(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        return merge(arr, 0, arr.length -1);
    }

    private static int merge(int[] arr, int left, int right) {
        if(left == right){
            return 0;
        }
        int count = 0;
        int mid = left + ((right - left) >> 1);
        count += merge(arr, left, mid);
        count += merge(arr, mid + 1, right);
        int rpIndex = mid +1;
        for(int l=left; l<=mid; l++){
            while (rpIndex <= right && arr[l] > 2* arr[rpIndex]){
                rpIndex ++;
            }
            count += rpIndex - (mid+1);
        }
        int lp = left;
        int rp = mid + 1;
        int[] helpArr = new int[right - left +1];
        int i=0;
        while (lp <= mid && rp <= right){
           helpArr[i++] = arr[lp] < arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid){
            helpArr[i++] = arr[lp++];
        }
        while (rp <= right){
            helpArr[i++] = arr[rp++];
        }
        for(int j=0; j<helpArr.length; j++){
            arr[left + j] = helpArr[j];
        }
        return count;
    }
}
