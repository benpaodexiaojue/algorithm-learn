package com.garen.dataStructure.heap;




//用数组实现的完全二叉树

public class CompletedBinaryTree<T> {

    private T[] arr ;
    private static final int ARR_LEN = 1000;
    private int size = 0;

    public CompletedBinaryTree() {
        this.arr = (T[])new Object[ARR_LEN];
    }

    public  void insertNode(T node){
        if(size >= ARR_LEN -1){
            throw new RuntimeException("空间大小已满。");//暂时先抛异常，之后将其改为扩容
        }
        arr[size++] = node;
    }

    public  void removeNode(T node){
        if(size >= ARR_LEN -1){
            throw new RuntimeException("空间大小已满。");//暂时先抛异常，之后将其改为扩容
        }
        arr[size++] = node;
    }

    public static void main(String[] args) {

    }

}
