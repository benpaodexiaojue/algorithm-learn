package com.garen.util;

public class BinaryUtil {
    public  static void  binaryPrint(int num){
        for(int i=31; i>=0 ; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
}
