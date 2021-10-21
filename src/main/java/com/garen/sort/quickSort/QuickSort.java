package com.garen.sort.quickSort;

import com.garen.dataStructure.MyStack;
import com.garen.util.ArrayUtil;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 10, 2, 4, 16, 8, 1, 17};
        int[] arr1 = ArrayUtil.copyArray(arr);
        int[] arr2 = ArrayUtil.copyArray(arr);
        int[] arr3 = ArrayUtil.copyArray(arr);
        quickSortProcess1(arr);
        ArrayUtil.printArray(arr);
        quickSortProcess2(arr1);
        ArrayUtil.printArray(arr1);
        quickSortProcess3(arr2);
        ArrayUtil.printArray(arr2);
        quickSortProcess4(arr3);
        ArrayUtil.printArray(arr3);
    }

    private static void quickSortProcess1(int[] arr) {
        if(arr == null || arr.length < 1){
            return;
        }
        quickSort1(arr, 0, arr.length-1);
    }

    private static void quickSortProcess2(int[] arr) {
        if(arr == null || arr.length < 1){
            return;
        }
        quickSort2(arr, 0, arr.length-1);
    }

    private static void quickSortProcess3(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSortProcess4(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        quickSortWithoutRecursion(arr);
    }

    //给定一个数组， 数组最后一个数作为 target 数
    //将数组中小于等于（<=） target 的数放在数组中 target 的左边，即小于区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    //每次只能排一个等于区的数
    //O(N^2)
    //额外空间复杂度： 最差 O(N)， 最好 O(logN)--> 需要记下等于区的下标
    private static void quickSort1(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int index = partition1(arr, left, right);
        quickSort1(arr, left, index-1);
        quickSort1(arr, index +1, right);
    }

    //给定一个数组， 数组最后一个数作为 target 数
    //将数组中小于（<） target 的数放在数组中 target 的左边，即小于区
    //将数组中等于（==） target 的数放在数组中小于区与大于区中间， 即中间区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    //一次就能排好等于区的所有数-->多个重复数效率快一点
    //O(N^2)
    //额外空间复杂度： 最差 O(N)， 最好 O(logN)--> 需要记下等于区的下标
    private static void quickSort2(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int[] eqArea = partition2(arr, left, right);
        quickSort2(arr, left, eqArea[0]);
        quickSort2(arr, eqArea[1] , right);
    }

    //给定一个数组， 随机一个数组中的数与最后一个数交换，交换后最后一个数作为 target 数
    //将数组中小于（<） target 的数放在数组中 target 的左边，即小于区
    //将数组中等于（==） target 的数放在数组中小于区与大于区中间， 即中间区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    //一次就能排好等于区的所有数-->多个重复数效率快一点
    //O(N^2)
    //额外空间复杂度： 最差 O(N)， 最好 O(logN)--> 需要记下等于区的下标
    private static void quickSort3(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        swap(arr, right, left + (int)(Math.random()*(right - left+1)));
        int[] eqArea = partition2(arr, left, right);
        quickSort3(arr, left, eqArea[0]);
        quickSort3(arr, eqArea[1] , right);
    }

    //给定一个数组， 随机一个数组中的数与最后一个数交换，交换后最后一个数作为 target 数
    //将数组中小于（<） target 的数放在数组中 target 的左边，即小于区
    //将数组中等于（==） target 的数放在数组中小于区与大于区中间， 即中间区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    //一次就能排好等于区的所有数-->多个重复数效率快一点
    //O(N^2)
    //额外空间复杂度： 最差 O(N)， 最好 O(logN)--> 需要记下等于区的下标
    //非递归版，使用 栈（stack） 来记录相等区的位置
    private static void quickSortWithoutRecursion(int[] arr) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(arr.length-1);
        do{
            int right = stack.pop();
            int left = stack.pop();
            if(left < right){
                swap(arr, right, left + (int)(Math.random()*(right - left+1)));
                int[] eqArea = partition2(arr, left, right);
                stack.push(left);
                stack.push(eqArea[0]);
                stack.push(eqArea[1]);
                stack.push(right);
            }
        }while (!stack.isEmpty());
    }

    //给定一个数组， 一个 target 数
    //将数组中小于等于（<=） target 的数放在数组中 target 的左边，即小于区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    private static int partition1(int[] arr, int left, int right){
        int target = arr[right];
        int lessArea = left -1;
        for(int i=left; i < right; i ++){
            if(arr[i] <= target){
                swap(arr, i, ++lessArea);
            }
        }
        swap(arr, ++lessArea, right);
        return lessArea;
    }

    //给定一个数组， 一个 target 数
    //将数组中小于（<） target 的数放在数组中 target 的左边，即小于区
    //将数组中等于（==） target 的数放在数组中小于区与大于区中间， 即中间区
    //将数组中大（>） target 的数放在数组中 target 的右边， 即大于区
    private static int[] partition2(int[] arr, int left, int right){
        int target = arr[right];
        int lessArea = left-1;
        int greaterArea = right;// 由于第 right 位作为target， 所以不参与数组中的数的比较， 故 大于区从 right开始

        for(int i=left; i<right; i ++){
            if(i >= greaterArea){
                break;
            }
            if(arr[i] < target){
                swap(arr, i, ++lessArea);
            }else if(arr[i] >target){
                swap(arr, i , --greaterArea);
                i--;
            }
        }
        swap(arr, right, greaterArea);
        return new int[]{lessArea, ++greaterArea};// 小于区的下一位，大于区的前一位
    }

    private static void swap(int[] arr, int one, int another) {
        int temp = arr[one];
        arr[one] = arr[another];
        arr[another] = temp;
    }
}
