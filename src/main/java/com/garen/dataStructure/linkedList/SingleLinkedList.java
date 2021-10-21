package com.garen.dataStructure.linkedList;

import com.garen.util.ArrayUtil;

public class SingleLinkedList {

    public static void main(String[] args){

//        SingleLinkedNode head = createOrderedSingleLinkedList(5);
//        ArrayUtil.printSingleLinkedList(head);
//        head = reversalSingleLinkList(head);
//        ArrayUtil.printSingleLinkedList(head);
//        SingleLinkedNode head1 = createDisorderlySingleLinkedList(15);
//        ArrayUtil.printSingleLinkedList(head1);
//        head1 = reversalSingleLinkList(head1);
//        ArrayUtil.printSingleLinkedList(head1);

        SingleLinkedNode head2 = createOrderedSingleLinkedList(15);
        ArrayUtil.printSingleLinkedList(head2);
        SingleLinkedNode newHead = remove(head2, 14);
        ArrayUtil.printSingleLinkedList(newHead);

    }
    public static SingleLinkedNode remove(SingleLinkedNode head, int data) {
        SingleLinkedNode pre = null;
        SingleLinkedNode cur = head;
        while (cur != null){
            SingleLinkedNode next = cur.getNext();
            if(cur.getData() == data){
                if(cur == head){
                    head = next;
                }else{
                    pre.setNext(next);
                }
            }
            pre = cur;
            cur = next;
        }
        return head;
    }


    public static SingleLinkedNode reversalSingleLinkList(SingleLinkedNode head) {
        SingleLinkedNode pre = null;
        SingleLinkedNode cur = head;
        SingleLinkedNode next = null;
        while (cur != null){
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur=next;
        }
        return pre;
    }

    private static SingleLinkedNode createDisorderlySingleLinkedList(int length) {
        SingleLinkedNode head = new SingleLinkedNode((int)(Math.random() * 100));
        SingleLinkedNode cur = head;
        for(int i = 1; i < length; i++){
            cur.setNext(new SingleLinkedNode((int)(Math.random() * 100)));
            cur = cur.getNext();
        }
        return head;
    }

    public static SingleLinkedNode createOrderedSingleLinkedList(int length) {
        SingleLinkedNode head = new SingleLinkedNode(0);
        SingleLinkedNode cur = head;
        for(int i = 1; i < length; i++){
            cur.setNext(new SingleLinkedNode(i));
            cur = cur.getNext();
        }
        return head;
    }


}
