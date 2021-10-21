package com.garen.dataStructure.queue;

import com.garen.dataStructure.linkedList.DoubleDirectionLinkedNode;
import com.garen.dataStructure.linkedList.DoubleDirectionLinkedNodeT;

public class MyQueue<T> {
    private final int DEFAULT_LENGTH = 10;
    private int maxLength = 10;
    private DoubleDirectionLinkedNodeT<T> head =null;
    private DoubleDirectionLinkedNodeT<T> tail =null;
    private int size = 0;

    public MyQueue() {
    }

    public MyQueue(int length) {
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void add(T data){
        if(size >= maxLength){
            throw new RuntimeException("队列空间已满，无法继续插入数据。");
        }
        DoubleDirectionLinkedNodeT<T> node = new DoubleDirectionLinkedNodeT<T>(data);
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

    public T poll(){
        if (head !=null){
            DoubleDirectionLinkedNodeT<T> next = head.getNext();
            T data = head.getData();
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

    public T peak(){
        if (head !=null){
            return head.getData();
        }
        return null;
    }
}
