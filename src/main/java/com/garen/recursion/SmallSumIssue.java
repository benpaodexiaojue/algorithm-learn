package com.garen.recursion;

import com.garen.util.ArrayUtil;

public class SmallSumIssue {
    public static void main(String[] args) {
        //题目：一个数组，对于每个数，在其前面的数比其小的，将这些比其小的数累加，求最终的和
        int[] arr = {2,4,1,2,6,4,8,3,9,2};
        int[] copyArr = ArrayUtil.copyArray(arr);
        ArrayUtil.printArray(arr);
        int sum = process(arr);
        int sum1 =test(copyArr);
        ArrayUtil.printArray(arr);
        System.out.println("sum:" + sum);
        System.out.println("sum1:" + sum1);
        System.out.println(sum == sum1);
    }

    private static int process(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        int left = 0;
        int right = arr.length -1;
        return smallSum(arr, left, right);
    }

    private static int test(int[] arr) {
        int sum = 0;
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < i ; j++){
                if(arr[j] < arr[i]){
                    sum += arr[j];
                }
            }
        }
        return sum;
    }


    private static int smallSum(int[] arr, int left, int right) {
        if(left == right){
            return 0;
        }
        int sum = 0;
        int mid = left + ((right - left)>>1);
        sum += smallSum(arr, left, mid);
        sum += smallSum(arr, mid + 1, right);
        int lp = left;
        int rp = mid + 1;
        int[] helpArr = new int[right - left +1];
        int i =0;
        while (lp <= mid && rp <= right){
            if(arr[lp] < arr[rp]){
                helpArr[i++] = arr[lp];
                sum += (right - rp +1) * arr[lp++];//左边当前lp位置的数， 如果比 右边rp位置的数小， 则也会比rp后面的数小， 则一个有 (right - rp +1) 个
            }else {
                helpArr[i++] = arr[rp++];
            }
        }
        while (lp <= mid){
            helpArr[i++] = arr[lp++];
        }
        while (rp <= right){
            helpArr[i++] = arr[rp++];
        }
        for(int j=0; j<helpArr.length; j ++){
            arr[left + j] = helpArr[j];
        }
        return sum;
    }
}
