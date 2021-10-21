package com.garen.dataStructure;

public class MyStack<T> {
    private final int DEFAULT_LENGTH = 10;
    private int maxLength = 10;
    private DoubleDirectionLinkedNodeT head =null;
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
        DoubleDirectionLinkedNodeT node = new DoubleDirectionLinkedNodeT(data);
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
            DoubleDirectionLinkedNodeT next = head.getNext();
            T data = (T) head.getData();
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
            DoubleDirectionLinkedNodeT next = head.getNext();
            return (T) head.getData();
        }
        return null;
    }

    public boolean isEmpty() {
        return size <=0;
    }
}
