package com.garen.sort.heapSort;

import com.garen.util.ArrayUtil;



public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 4, 2, 9, 5, 8, 3, 10};

        ArrayUtil.printArray(arr);
        heapSort(arr);
        ArrayUtil.printArray(arr);

    }

    private static void heapSort(int[] arr) {
        //先将数组整理成 大根堆
        for(int i=0; i < arr.length; i++){
            heapInsert(arr, i, i);
        }
        //循环数组，
        //1. 堆的根节点作为最大值与堆的最后个数交换，这样数组的最大数就放在数组的最后一位了；
        //2. 第二大的数同理，在剩下的数中，调整为大根堆，然后将当前堆的第一个数与堆的最后一个数交换，
        //3. 如此重复下去，直到最小数放在数组的 0 位为止
        for(int i =0; i < arr.length; i++){
            swap(arr, 0, arr.length-1-i);
            downAdjust(arr, arr.length-1 - i);
        }
    }

    private static void downAdjust(int[] arr, int size) {
        int index = 0;
        int leftChildIndex = 1;
        while (leftChildIndex < size){
            int rightChildIndex = leftChildIndex +1;
            int maxChildIndex = rightChildIndex < size && arr[rightChildIndex] > arr[leftChildIndex]? rightChildIndex: leftChildIndex;
            if(arr[maxChildIndex] > arr[index]){
                swap(arr, maxChildIndex, index);
                index = maxChildIndex;
                leftChildIndex = index * 2 + 1;
            }else {
                break;
            }
        }
    }

    private static void heapInsert(int[] arr, int curIndex, int size) {
        swap(arr, curIndex, size);
        while (arr[curIndex] > arr[(curIndex-1)/2]){
            swap(arr, curIndex, (curIndex-1)/2);
            curIndex = (curIndex-1)/2;
        }
    }



    private static void swap(int[] arr, int one, int another) {
        int temp = arr[one];
        arr[one] = arr[another];
        arr[another] = temp;
    }
}
