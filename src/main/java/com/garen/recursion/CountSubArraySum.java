package com.garen.recursion;

import com.garen.util.ArrayUtil;

public class CountSubArraySum {


    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, -2, 5, 8, -3, 9};
        int lower = 5;
        int upper = 10;
        int[] copyArr = ArrayUtil.copyArray(arr);
        ArrayUtil.printArray(arr);
        int target = test(copyArr, lower, upper);
        System.out.println(target);
        int count = countSubArraySum(arr, lower, upper);
        System.out.println(count);

    }

    private static int countSubArraySum(int[] arr, int lower, int upper) {
        if(arr ==null || arr.length ==0){
            return 0;
        }
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for(int i=1; i < arr.length; i ++){
            sumArr[i] = sumArr[i-1] +arr[i];
        }
        ArrayUtil.printArray(sumArr);
        int count = merge(sumArr, 0, sumArr.length - 1, lower, upper);
        ArrayUtil.printArray(sumArr);
        return count;
    }

    private static int merge(int[] sumArr, int left, int right, int lower, int upper) {
        if(left == right){
            if(sumArr[left] >= lower && sumArr[left] <= upper){
                return 1;
            }else {
                return 0;
            }
        }
        int count = 0 ;
        int mid = left + ((right - left) >>1);
        count += merge(sumArr, left, mid, lower, upper);
        count += merge(sumArr, mid +1, right, lower, upper);
        int lw = left;
        int rw = left;
        for(int i=mid +1; i <=right; i++){
            int min = sumArr[i] - upper;
            int max = sumArr[i] - lower;
            while (rw <= mid && sumArr[rw] <= max) {
                rw++;
            }
            while (lw <= mid && sumArr[lw] < min) {
                lw++;
            }
            count += rw-lw;
        }
        int lp = left;
        int rp = mid+1;
        int i=0;
        int[] helpArr = new int[right - left +1];
        while (lp <= mid && rp <= right){
            helpArr[i++] = sumArr[lp] < sumArr[rp] ? sumArr[lp++] : sumArr[rp++];
        }
        while (lp <= mid){
            helpArr[i++] = sumArr[lp++];
        }
        while (rp <= right){
            helpArr[i++] = sumArr[rp++];
        }

        for(int j=0; j < helpArr.length; j++){
            sumArr[left + j] = helpArr[j];
        }
        return count;
    }

    private static int test(int[] arr, int lower, int upper) {
        if(arr ==null || arr.length ==0){
            return 0;
        }
        int count = 0;
        for (int i=0; i< arr.length; i++){
            for(int j=i; j <arr.length; j++){
                int subSum = sum(arr, i, j);
                if(subSum >= lower && subSum <= upper){
                    count ++;
                }
            }
        }
        return count;
    }

    private static int sum(int[] copyArr, int start, int end) {
        int sum = 0;
        for (int i=start; i <=end; i ++){
            sum += copyArr[i];
        }
        return sum;
    }
}
