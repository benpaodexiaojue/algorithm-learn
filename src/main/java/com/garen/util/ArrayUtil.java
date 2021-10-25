package com.garen.util;

import com.garen.dataStructure.linkedList.DoubleDirectionLinkedNode;
import com.garen.dataStructure.linkedList.SingleLinkedNode;

import java.security.SecureRandom;

public class ArrayUtil {
    public static int[] creatArray(int length, int maxNum) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = randomGenerateNum(maxNum);
        }
        return arr;
    }

    private static int randomGenerateNum(int maxNum) {
        SecureRandom secureRandom = new SecureRandom();
        int num = Math.abs(secureRandom.nextInt());
        return num % maxNum;
    }

    public static int[] copyArray(int[] orgArr) {
        int[] copyArr = new int[orgArr.length];
        for (int i=0; i < orgArr.length; i ++){
            copyArr[i] = orgArr[i];
        }
        return copyArr;
    }

    public static boolean equals(int[] orgArr, int[] targetArray) {
        if(orgArr == null | targetArray == null){
            System.out.println("Error: array is null");
            return false;
        }
        if(orgArr.length == 0 | targetArray.length == 0){
            System.out.println("Error: array is Empty");
            return false;
        }

        if(orgArr.length != targetArray.length){
            System.out.println("Error: array length is not equaled");
            return false;
        }

        for(int i = 0; i < orgArr.length; i ++){
            if(orgArr[i] != targetArray[i]){
                System.out.println("Error: array is not equaled");
                return false;
            }
        }
        return true;
    }


    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void printArray(int[] arr, int start, int end) {
        for(int i = start; i <= end; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(Object[] arr, int start, int end) {
        for(int i = start; i <= end; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printSingleLinkedList(SingleLinkedNode head) {
        SingleLinkedNode cur = head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void printDoubleDirectionLinkedList(DoubleDirectionLinkedNode head) {
        DoubleDirectionLinkedNode cur = head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void reversePrintDoubleDirectionLinkedList(DoubleDirectionLinkedNode tail) {
        DoubleDirectionLinkedNode cur = tail;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getPre();
        }
        System.out.println();
    }
}
