package com.garen.dataStructure;

public class MyStackByQueue {
    MyQueueByArray baseQue=null;
    MyQueueByArray helpQue=null;
    int maxLength=0;
    int size = 0;


    public MyStackByQueue(int length) {
        baseQue = new MyQueueByArray(length);
        helpQue = new MyQueueByArray(length);
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void push(int data){
        if(size >= maxLength){
            throw new RuntimeException("栈空间已经满了， 不能继续添加数据！！");
        }
        baseQue.add(data);
        size ++;
    }
    
    public Integer pop(){
        for(int i=1; i<size; i++){
            helpQue.add(baseQue.poll());
        }
        Integer data = baseQue.poll();
        size --;
        MyQueueByArray temp = helpQue;
        helpQue = baseQue;
        baseQue = temp;
        return data;
    }

    public Integer peak(){
        for(int i=1; i<size; i++){
            helpQue.add(baseQue.poll());
        }
        Integer data = baseQue.poll();
        helpQue.add(data);
        for(int i=1; i<=size; i++){
            baseQue.add(helpQue.poll());
        }
        return data;
    }


    public static void main(String[] args){
        MyStackByQueue stack = new MyStackByQueue(15);
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
            System.out.println(stack.peak());
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
            System.out.println(stack.peak());
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
