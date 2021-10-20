package com.garen.search;

import com.garen.util.ArrayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindOutKOddTimesNum {

    public static void main(String[] args){
        //题目：
        //一个数组中有一种数出现了K次， 其他数出现M次，
        // 找出这个出现K次的数
        //M>1 , K<M
        //要求， 额外空间复杂度O(1), 时间复杂度O(N)-->也就说不能使用 hashMap的方式

        int count = 10000;
        while (count >0 ){
//            int[] arr = {2, 2, 4, 2, 2, 2, 2, 2, 3, 4, 3, 3, 3, 3, 4, 3, 3};
            int kind = randomNum(100) + 2;//1~10
            int a = randomNum(10) + 1;//1~10
            int b = randomNum(10) + 1;//1~10

            // k < m
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if(k == m){
                m ++;
            }

            int[] randomArr = generateRandomArray(kind, 10000, k, m);
            int result = searchKOddTimesNum(randomArr, k, m);
            int expected = checkResult(randomArr, k, m);
            if(result != expected){
                ArrayUtil.printArray(randomArr);
                System.out.println(result+" "+expected);
                return;
            }
            count -- ;
        }
        System.out.println("Success!!!!");

    }

    private static int[] generateRandomArray(int numKind, int numRange, int k, int m) {
        int[] arr = new int[k + m * (numKind - 1)];
        Set<Integer> numSet = new HashSet<Integer>();
        //生成 k 次出现的数
        int arrIndex = 0;
        int num = generateNewNum(numRange, numSet);
        for(int i=1; i <= k; i++){
            arr[arrIndex++] = num;
        }
        //生成 k 次出现的数
        for(int i = 2; i <= numKind; i++ ){
           int mNum = generateNewNum(numRange, numSet);
           for(int j=1; j<=m; j++){
               arr[arrIndex++] = mNum;
           }
        }
//        ArrayUtil.printArray(arr);
        //以上数组yi填好
        //---------------------
        for(int t=0; t<arr.length; t++){
            int j = randomNum(arr.length);
            int tmp = arr[t];
            arr[t] = arr[j];
            arr[j] = tmp;
        }

        return arr;
    }

    private static int generateNewNum(int NumRange, Set<Integer> numSet) {
        int num = 0;
        do{
            num = randomNum(NumRange);
        }while (numSet.contains(num));
        numSet.add(num);
        return num;
    }

    private static int randomNum(int NumRange) {
        return (int) (Math.random() * NumRange);
    }

    private static int searchKOddTimesNum(int[] arr, int k, int m) {
        //题解：
        //思考：这道题涉及到各个数出现的次数，int 类型在 java 中是 32 位
        //对于每一位，
        // 如果出现了K次的数的某个位是1， 那么这个数在这个位出现了 k 次
        // 如果出现了m次的数的某个位是1， 那么这个数在这个位出现了 m的n倍次，n是在这个位出现M次的数的个数
        // 公式就来了， 对于某个位的值是 1 的位， 这个位出现的总次数：total = k + m * n
        // total % m 如果等于 k, 那么出现了K次的数在这个位的数是 1
        // 统计所有 位都出现了 K 位的数，将其转化为 int 类型即所求。
        int[] bitNum = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i <= 31; i++) {
//                //arr[j]>>i 右移 i 位 后， 与 1 相与（&）， 即可得到第 i 位是否是1
//                if (((arr[j] >> i) & 1) == 1) {
//                    //如果是 1 ，则统计 +1
//                    bitNum[i] += 1;
//                }
                //重构后
                    bitNum[i] += ((arr[j] >> i) & 1);
            }
        }
        int result = 0;

//        for(int i=0; i<=31; i ++){
//            if((bitNum[i] % m) == k){
//                result += (1 << i);
//            }
//        }
        // 用 | 比 + 速度快一点
        for(int i=0; i<=31; i ++){
            if((bitNum[i] % m) == k){
                result |= (1 << i);
            }
        }
        return result;
    }


    private static int checkResult(int[] arr, int k, int m){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        for (Integer num : map.keySet()) {
            if(map.get(num) == k){
                return num;
            }
        }
        return -1;
    }
}
