package com.garen.search;

public class BinarySearch {


    public static void main(String[] args){
        int[] sortedArr = {2, 32, 41, 45, 55, 66, 2000, 45555};
        System.out.println("32:" + binarySearch(sortedArr, 32));
        System.out.println("45555:" + binarySearch(sortedArr, 45555));
        System.out.println("66:" + binarySearch(sortedArr, 66));
        System.out.println("55:" + binarySearch(sortedArr, 55));
        System.out.println("2:" + binarySearch(sortedArr, 2));
        System.out.println("42:" + binarySearch(sortedArr, 42));
        System.out.println("41:" + binarySearch(sortedArr, 41));
        System.out.println("2000:" + binarySearch(sortedArr, 2000));
        System.out.println("2:" + binarySearch(sortedArr, 2));
        System.out.println("45:" + binarySearch(sortedArr, 45));
    }

    private static int binarySearch(int[] sortedArr, int target) {
        if(sortedArr == null || sortedArr.length == 0){
            return -1;
        }
        int left = 0;
        int right = sortedArr.length-1;
        int mid = 0;
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if(target == sortedArr[mid]){
                return mid;
            }else if(target < sortedArr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
