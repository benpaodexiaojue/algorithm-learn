package com.garen.dataStructure;


//也可实现为动态调整长度的功能
public class MyStackByLinkedList {
    private final int DEFAULT_LENGTH = 10;
    private int maxLength = 10;
    private DoubleDirectionLinkedNode head =null;
    private int size = 0;

    public MyStackByLinkedList() {
    }

    public MyStackByLinkedList(int length) {
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void push(int data){
        if(size >= maxLength){
            throw new RuntimeException("栈空间已满，无法继续插入数据。");
        }
        DoubleDirectionLinkedNode node = new DoubleDirectionLinkedNode(data);
        if(head == null){
            head = node;
        }else{
            head.setPre(node);
            node.setNext(head);
            head = node;
        }
         size ++;
    }

    public Integer pop(){
        if (head !=null){
            DoubleDirectionLinkedNode next = head.getNext();
            int data = head.getData();
            if(next !=null){
                next.setPre(null);
            }
            head = next;
            size --;
            return data;
        }
        return null;
    }

    public Integer peak(){
        if (head !=null){
            DoubleDirectionLinkedNode next = head.getNext();
            return head.getData();
        }
        return null;
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
