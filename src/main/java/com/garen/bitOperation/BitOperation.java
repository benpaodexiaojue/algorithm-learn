package com.garen.bitOperation;

import com.garen.util.BinaryUtil;

public class BitOperation {

    public static void main(String[] args){

        //题目：
        // 怎么把一个int类型的数，
        // 提取出其二进制中最右侧的1，形成一个新的int数


        System.out.println(findRightestOne(8));
        System.out.println(findRightestOne(12));
        System.out.println(findRightestOne(13));
    }

    public static int findRightestOne(int num){
        return num & (-num);//num & (~num +1)
    }
}
