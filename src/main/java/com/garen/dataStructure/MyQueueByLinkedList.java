package com.garen.dataStructure;


//也可实现为动态调整长度的功能
public class MyQueueByLinkedList {
    private final int DEFAULT_LENGTH = 10;
    private int maxLength = 10;
    private DoubleDirectionLinkedNode head =null;
    private DoubleDirectionLinkedNode tail =null;
    private int size = 0;

    public MyQueueByLinkedList() {
    }

    public MyQueueByLinkedList(int length) {
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void add(int data){
        if(size >= maxLength){
            throw new RuntimeException("队列空间已满，无法继续插入数据。");
        }
        DoubleDirectionLinkedNode node = new DoubleDirectionLinkedNode(data);
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.setNext(node);
            node.setPre(tail);
            tail = node;
        }
         size ++;
    }

    public Integer poll(){
        if (head !=null){
            DoubleDirectionLinkedNode next = head.getNext();
            int data = head.getData();
            if(next !=null){
                next.setPre(null);
            }
            head = next;
            size --;
            if(head == null){
                tail = null;
            }
            return data;
        }
        return null;
    }


    public static void main(String[] args){
        MyQueueByLinkedList que = new MyQueueByLinkedList(15);
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
