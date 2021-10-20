package com.garen.search;

public class PartialMinimumSearch {

    public static void main(String[] args){
        int[] arr = {2, 32, 41, 45, 55, 66, 2000, 45555};
        System.out.println(partialMinimumSearch(arr));
        int[] arr1 = {45555, 2000, 66, 55, 45, 41, 32, 2};
        System.out.println(partialMinimumSearch(arr1));

        int[] arr2 = {45555, 2000, 66, 2, 55, 45, 41, 32};
        System.out.println(partialMinimumSearch(arr2));

        int[] arr3 = {45555, 2000, 2, 66, 55, 45, 41, 32};
        System.out.println(partialMinimumSearch(arr3));

        int[] arr4 = {45555, 2000, 66, 55, 45, 2, 41, 32};
        System.out.println(partialMinimumSearch(arr4));

        int[] a = {1};

        a[0] = a[0] ^ a[0];
        a[0] = a[0] ^ a[0];
        a[0] = a[0] ^ a[0];
        System.out.println(a[0] );

    }

    private static int partialMinimumSearch(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if( (mid != 0) && arr[mid] < arr[mid-1] && (mid == arr.length-1)){
                return mid;
            }else if((mid != arr.length-1) && arr[mid] < arr[mid+1] && (mid == 0)){
                return mid;
            }else if (arr[mid] < arr[mid+1] && arr[mid] < arr[mid-1]){
                return mid;
            }else if(arr[mid] > arr[mid-1]){
                right = mid -1;
            }else if(arr[mid] > arr[mid+1]){
                left = mid +1;
            }
        }
        return -1;
    }


}
