package com.garen.dataStructure.linkedList;

import com.garen.util.ArrayUtil;

public class DoubleDirectionLinkedList {

    public static void main(String[] args){
//        DoubleDirectionLinkedNode head = createDisorderlyDoubleDirectionLinkedList(15);
//        ArrayUtil.printDoubleDirectionLinkedList(head);
//        head = reverse(head);
//        ArrayUtil.printDoubleDirectionLinkedList(head);

        DoubleDirectionLinkedNode head = createOrderedDoubleDirectionLinkedList(15);
        ArrayUtil.printDoubleDirectionLinkedList(head);
        DoubleDirectionLinkedNode newHead = remove(head, 5);
        ArrayUtil.printDoubleDirectionLinkedList(newHead);
    }

    private static DoubleDirectionLinkedNode remove(DoubleDirectionLinkedNode head, int data) {
        DoubleDirectionLinkedNode pre = null;
        DoubleDirectionLinkedNode cur = head;
        while (cur != null){
            DoubleDirectionLinkedNode next = cur.getNext();
            if(cur.getData() == data){
                if(cur == head){
                    head = next;
                    next.setPre(null);
                }else if(next == null){
                    pre.setNext(null);
                }else{
                    pre.setNext(next);
                    next.setPre(pre);
                }
            }
            pre = cur;
            cur = cur.getNext();
        }
        return head;
    }

    public static DoubleDirectionLinkedNode reverse(DoubleDirectionLinkedNode head) {
        DoubleDirectionLinkedNode cur = head;
        DoubleDirectionLinkedNode pre = null;

        while(cur != null){
            DoubleDirectionLinkedNode next = cur.getNext();
            cur.setPre(next);
            cur.setNext(pre);

            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static void testCreate() {
        DoubleDirectionLinkedNode head = createDisorderlyDoubleDirectionLinkedList(10);
        ArrayUtil.printDoubleDirectionLinkedList(head);
        ArrayUtil.reversePrintDoubleDirectionLinkedList(getTail(head));
    }

    private static DoubleDirectionLinkedNode getTail(DoubleDirectionLinkedNode head) {
        DoubleDirectionLinkedNode cur = head;
        DoubleDirectionLinkedNode pre = null;
        while (cur != null){
            pre = cur;
            cur = cur.getNext();
        }
        return pre;
    }

    private static DoubleDirectionLinkedNode createDisorderlyDoubleDirectionLinkedList(int length) {
        DoubleDirectionLinkedNode head = new DoubleDirectionLinkedNode((int)(Math.random() * 100));
        DoubleDirectionLinkedNode cur = head;
        DoubleDirectionLinkedNode next = null;
        for(int i = 1; i < length; i++){
            //?????????????????????
            next = new DoubleDirectionLinkedNode((int) (Math.random() * 100));
            //??????????????????next????????????next??????
            cur.setNext(next);
            //?????????next?????????pre,next?????????pre ?????????????????????next???????????? null
            next.setPre(cur);

            //??????????????????
            cur = cur.getNext();
        }
        return head;
    }


    private static DoubleDirectionLinkedNode createOrderedDoubleDirectionLinkedList(int length) {
        DoubleDirectionLinkedNode head = new DoubleDirectionLinkedNode(0);
        DoubleDirectionLinkedNode cur = head;
        DoubleDirectionLinkedNode next = null;
        for(int i = 1; i < length; i++){
            //?????????????????????
            next = new DoubleDirectionLinkedNode(i);
            //??????????????????next????????????next??????
            cur.setNext(next);
            //?????????next?????????pre,next?????????pre ?????????????????????next???????????? null
            next.setPre(cur);

            //??????????????????
            cur = cur.getNext();
        }
        return head;
    }
}
