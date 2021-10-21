package com.garen.dataStructure.linkedList;


public class DoubleDirectionLinkedNodeT<T> {
    private T data;
    private DoubleDirectionLinkedNodeT pre;
    private DoubleDirectionLinkedNodeT next;

    public DoubleDirectionLinkedNodeT(T data) {
        this.data = data;
    }

    public DoubleDirectionLinkedNodeT(T data, DoubleDirectionLinkedNodeT pre, DoubleDirectionLinkedNodeT next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleDirectionLinkedNodeT getPre() {
        return pre;
    }

    public void setPre(DoubleDirectionLinkedNodeT pre) {
        this.pre = pre;
    }

    public DoubleDirectionLinkedNodeT getNext() {
        return next;
    }

    public void setNext(DoubleDirectionLinkedNodeT next) {
        this.next = next;
    }
}
