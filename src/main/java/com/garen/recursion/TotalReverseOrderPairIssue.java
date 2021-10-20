package com.garen.recursion;

import com.garen.util.ArrayUtil;

public class TotalReverseOrderPairIssue {
    public static void main(String[] args) {
        //题目： 求一个数组中，逆序对有多少对,
        //如： {4,3,5,2,1} 中， （4,3）,(4, 2), (3,1)等都是逆序对
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

    private static int test(int[] arr) {
        int total = 0;
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < i ; j++){
                if(arr[j] > arr[i]){
                    total ++;
                }
            }
        }
        return total;
    }

    private static int process(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        int left = 0;
        int right = arr.length -1;
        return totalReverseOrderPair(arr, left, right);
    }

    private static int totalReverseOrderPair(int[] arr, int left, int right) {
        if(left == right){
            return 0;
        }
        int total = 0;
        int mid = left + ((right - left) >>1);
        total += totalReverseOrderPair(arr, left, mid);
        total += totalReverseOrderPair(arr, mid+1, right);
        int[] helpArr = new int[right - left +1];
        int lp = left;
        int rp = mid +1;
        int i =0;
        while (lp <= mid && rp <= right){
            if(arr[lp] > arr[rp]){
                helpArr[i++] = arr[lp++];
                total += right - rp +1;
            }else{
                helpArr[i++] =arr[rp++];
            }
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
        return total;
    }
}
