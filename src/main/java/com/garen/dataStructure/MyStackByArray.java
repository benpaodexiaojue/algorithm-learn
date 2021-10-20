package com.garen.dataStructure;

public class MyStackByArray {
    Integer[] arr = new Integer[10];
    int offSet = 0;
    int size = 0;

    public MyStackByArray(int length) {
        arr = new Integer[length];;
    }

    public int getSize() {
        return size;
    }

    public void push(int data){
        if(size >= arr.length){
            throw new RuntimeException("栈空间已经满了， 不能继续添加数据！！");
        }
        arr[offSet++] = data;
        size ++;
    }
    
    public Integer pop(){
        if(size == 0){
            return null;
        }
        size --;
        return arr[--offSet];
    }

    public Integer peak(){
        if(size == 0){
            return null;
        }
        int peakIndex = this.offSet -1;
        return arr[peakIndex];
    }


    public static void main(String[] args){
        MyStackByArray stack = new MyStackByArray(15);
        try{
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.push(10);
            stack.push(11);
            stack.push(12);
            stack.push(13);
            stack.push(14);
            stack.push(15);
            stack.push(16);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("stack size:" + stack.getSize());
        int size = stack.getSize();
        for(int i = 0; i< size; i++){
            System.out.println(stack.pop());
        }
        System.out.println("stack size:" + stack.getSize());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println("stack size:" + stack.getSize());
        int size1 = stack.getSize();
        for(int i = 0; i< size1; i++){
            System.out.println(stack.pop());
        }
        System.out.println("stack size:" + stack.getSize());

        stack.push(1);
        System.out.println(stack.pop());
        System.out.println("stack size:" + stack.getSize());

        stack.push(1);
        System.out.println(stack.peak());
        System.out.println("stack size:" + stack.getSize());
        System.out.println(stack.pop());
        System.out.println("stack size:" + stack.getSize());
    }


}
