package com.garen.dataStructure;

//使用栈实现队列
public class MyQueueByStack {
    private final int DEFAULT_LENGTH = 10;
    private MyStackByArray baseStack =null;
    private MyStackByArray helpStack =null;
    private int size = 0;
    private int maxLength = 10;

    public MyQueueByStack() {
        baseStack = new MyStackByArray(DEFAULT_LENGTH);
        helpStack = new MyStackByArray(DEFAULT_LENGTH);
    }

    public MyQueueByStack(int length) {
        baseStack = new MyStackByArray(length);
        helpStack = new MyStackByArray(length);
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void add(int data){
        if(size >= maxLength){
            throw new RuntimeException("队列空间已满，无法继续插入数据。");
        }
        baseStack.push(data);
        size ++;
    }

    public Integer poll(){
        for(int i=1; i<size;i++){
            helpStack.push(baseStack.pop());
        }
        Integer data = baseStack.pop();
        size --;
        for(int i=1; i<=size;i++){
            baseStack.push(helpStack.pop());
        }
        return data;
    }


    public static void main(String[] args){
        MyQueueByStack que = new MyQueueByStack(15);
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
