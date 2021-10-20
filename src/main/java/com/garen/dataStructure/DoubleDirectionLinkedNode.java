package com.garen.dataStructure;


public class DoubleDirectionLinkedNode {
    private int data;
    private DoubleDirectionLinkedNode pre;
    private DoubleDirectionLinkedNode next;

    public DoubleDirectionLinkedNode(int data) {
        this.data = data;
    }

    public DoubleDirectionLinkedNode(int data, DoubleDirectionLinkedNode pre, DoubleDirectionLinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleDirectionLinkedNode getPre() {
        return pre;
    }

    public void setPre(DoubleDirectionLinkedNode pre) {
        this.pre = pre;
    }

    public DoubleDirectionLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleDirectionLinkedNode next) {
        this.next = next;
    }
}
