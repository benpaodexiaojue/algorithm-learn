package com.garen.dataStructure.stack;

import com.garen.dataStructure.linkedList.DoubleDirectionLinkedNodeT;

public class MyStack<T> {
    private final int DEFAULT_LENGTH = 10;
    private int maxLength = 10;
    private DoubleDirectionLinkedNodeT<T> head =null;
    private int size = 0;

    public MyStack() {
    }

    public MyStack(int length) {
        maxLength = length;
    }

    public int getSize() {
        return size;
    }

    public void push(T data){
        if(size >= maxLength){
            throw new RuntimeException("栈空间已满，无法继续插入数据。");
        }
        DoubleDirectionLinkedNodeT<T> node = new DoubleDirectionLinkedNodeT<T>(data);
        if(head == null){
            head = node;
        }else{
            head.setPre(node);
            node.setNext(head);
            head = node;
        }
        size ++;
    }

    public T pop(){
        if (head !=null){
            DoubleDirectionLinkedNodeT<T> next = head.getNext();
            T data = head.getData();
            if(next !=null){
                next.setPre(null);
            }
            head = next;
            size --;
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

    public boolean isEmpty() {
        return size <=0;
    }
}
