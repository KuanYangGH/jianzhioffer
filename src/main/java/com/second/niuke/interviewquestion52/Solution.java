package com.second.niuke.interviewquestion52;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author yangkuan
 */
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] B = new int[A.length];
        int[] D = new int[A.length];
        // initial value
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
            D[i] = 1;
        }
        //left down corner
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //right up corner
        for (int i = D.length - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }
        //multiply
        for (int i = 0; i < B.length; i++) {
            B[i] *= D[i];
        }
        return B;
    }
}
