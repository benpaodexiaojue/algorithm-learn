package com.garen.dataStructure.queue;


//也可实现为动态调整长度的功能
public class MyQueueByArray {
    private final int DEFAULT_LENGTH = 10;
    private Integer[] arr;
    private int addIndex = 0;
    private int popIndex = 0;
    private int size = 0;

    public MyQueueByArray() {
        arr = new Integer[DEFAULT_LENGTH];
    }

    public MyQueueByArray(int length) {
        arr = new Integer[length];
    }

    public int getSize() {
        return size;
    }

    public void add(int data){
        if(size >= arr.length){
            //也可实现为动态调整长度的功能
            throw new RuntimeException("队列空间已经满了，不能继续添加");
        }
        arr[addIndex] = data;
        size++;
        addIndex++;
        if(addIndex > (arr.length -1)){
            addIndex =0;
        }
    }

    public Integer poll(){
        if(size == 0){
            return null;
        }
        Integer data = arr[popIndex];
        popIndex++;
        if(popIndex > (arr.length -1)){
            popIndex =0;
        }
        size--;
        return data;
    }


    public static void main(String[] args){
        MyQueueByArray que = new MyQueueByArray(15);
        try{
            que.add(1);
            que.add(2);
            que.add(3);
            que.add(4);
            que.add(5);
            que.add(6);
            que.add(7);
            que.add(8);
            que.add(9);
            que.add(10);
            que.add(11);
            que.add(12);
            que.add(13);
            que.add(14);
            que.add(15);
            que.add(16);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("queue size:" + que.getSize());
        int size = que.getSize();
        for(int i = 0; i< size; i++){
            System.out.println(que.poll());
        }
        System.out.println("queue size:" + que.getSize());

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);
        System.out.println("queue size:" + que.getSize());
        int size1 = que.getSize();
        for(int i = 0; i< size1; i++){
            System.out.println(que.poll());
        }
        System.out.println("queue size:" + que.getSize());

        que.add(1);
        System.out.println(que.poll());
        System.out.println("queue size:" + que.getSize());
    }


}
