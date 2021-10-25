package com.garen.dataStructure.heap;


import com.garen.util.ArrayUtil;
import sun.awt.datatransfer.DataTransferer;

import java.util.Comparator;


public class Heap<T> {

    private static final int ARR_LEN = 1000;
    Object[] arr ;
    int size = 0;
    Comparator<? super T> comparator;

    //默认小根堆
    public Heap() {
        arr = new Object[ARR_LEN];
    }

    //根据自定义比较器来定义大根堆或小根堆
    public Heap( Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.arr = new Object[ARR_LEN];
    }

    public void add(T data){
        if(size >= ARR_LEN -1){
            throw new RuntimeException("空间大小已满！");
        }
        arr[size++] = data;
        if(comparator == null){
            upAdjustWithDefaultComparator(size - 1);
        }else{
            upAdjustWithDefinedComparator(size -1);
        }
    }

    public T peek(){
        if(size == 0){
            return null;
        }
        return (T)arr[0];
    }

    public T poll(){
        if(size == 0){
            return null;
        }
        T result = (T)arr[0];
        swap(arr, 0, --size);
        if(comparator == null){
            downAdjustWithDefaultComparator(0);
        }else {
            downAdjustWithDefinedComparator(0);
        }
        return result;
    }

    private void upAdjustWithDefaultComparator(int index) {
        int parentIndex = (index - 1) / 2;
        while (((Comparable<? super T>)arr[index]).compareTo((T)arr[parentIndex]) < 0) {
            swap(arr, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    private void upAdjustWithDefinedComparator(int index) {
        int parentIndex = (index - 1) / 2;
        while (comparator.compare((T)arr[index],(T)arr[parentIndex]) < 0) {
            swap(arr, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void downAdjustWithDefinedComparator(int index) {
        int leftChildIndex = index * 2 + 1;

        while (leftChildIndex < size) {
            int rightChildIndex = leftChildIndex + 1;

            //请子节点中最小的数的下标
            int minChildIndex = rightChildIndex < size && comparator.compare((T)arr[rightChildIndex], (T)arr[leftChildIndex]) < 0 ? rightChildIndex : leftChildIndex;

            if (comparator.compare((T)arr[minChildIndex], (T)arr[index])< 0) {
                swap(arr, minChildIndex, index);
                index = minChildIndex;
                leftChildIndex = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void downAdjustWithDefaultComparator(int index) {
        int leftChildIndex = index * 2 + 1;

        while (leftChildIndex < size) {
            int rightChildIndex = leftChildIndex + 1;

            //请子节点中最小的数的下标
            int minChildIndex = rightChildIndex < size && ((Comparable<? super T>)arr[rightChildIndex]).compareTo((T)arr[leftChildIndex]) < 0 ? rightChildIndex : leftChildIndex;

            if (((Comparable<? super T>)arr[minChildIndex]).compareTo((T)arr[index])< 0) {
                swap(arr, minChildIndex, index);
                index = minChildIndex;
                leftChildIndex = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void swap(Object[] arr, int one, int another) {
        Object temp = arr[one];
        arr[one] = arr[another];
        arr[another] = temp;
    }


    public static void main(String[] args) {
        System.out.println("------测试默认比较器（小根堆）开始--------");
        testWithDefaultComparator();
        System.out.println("------测试默认比较器（小根堆）结束--------");


        System.out.println("------测试默认比较器（大根堆）开始--------");
        testWithDefinedComparator();
        System.out.println("------测试默认比较器（大根堆）结束--------");

    }


    private static void testWithDefaultComparator() {
        int[] arr = {7, 4, 6, 3, 5, 8};
        Heap<Integer> heap = new Heap<>();
        for(int i=0; i< arr.length; i++){
            heap.add(arr[i]);
        }
        ArrayUtil.printArray(heap.arr, 0, heap.size-1);
//        heap.arr[1] = 9;
//        heap.downAdjustWithDefaultComparator(1);
//        heap.upAdjustWithDefaultComparator(1);
//
//        heap.arr[2] = 1;
//        heap.downAdjustWithDefaultComparator(2);
//        heap.upAdjustWithDefaultComparator(2);
//        ArrayUtil.printArray(heap.arr, 0, heap.size-1);
        //测试 poll
        while (heap.size > 0){
            System.out.println(heap.peek());
            System.out.println(heap.poll());
            ArrayUtil.printArray(heap.arr,0, heap.size-1);
        }
    }


    private static void testWithDefinedComparator() {
        int[] arr = {7, 4, 6, 3, 5, 8};
        Heap<Integer> heap = new Heap<Integer>(new MyComparator<Integer>());
        for(int i=0; i< arr.length; i++){
            heap.add(arr[i]);
        }
        ArrayUtil.printArray(heap.arr, 0, heap.size-1);
//        heap.arr[1] = 9;
//        heap.downAdjustWithDefaultComparator(1);
//        heap.upAdjustWithDefaultComparator(1);
//
//        heap.arr[2] = 1;
//        heap.downAdjustWithDefaultComparator(2);
//        heap.upAdjustWithDefaultComparator(2);
//        ArrayUtil.printArray(heap.arr, 0, heap.size-1);
        //测试 poll
        while (heap.size > 0){
            System.out.println(heap.peek());
            System.out.println(heap.poll());
            ArrayUtil.printArray(heap.arr,0, heap.size-1);
        }
    }
}
