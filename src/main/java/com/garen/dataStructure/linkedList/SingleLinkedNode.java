package com.garen.dataStructure.linkedList;


public class SingleLinkedNode {
    private int data;
    private SingleLinkedNode next;

    public SingleLinkedNode(int data) {
        this.data = data;
    }

    public SingleLinkedNode(int data, SingleLinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkedNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode next) {
        this.next = next;
    }
}
