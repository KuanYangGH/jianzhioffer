package com.second.chapter6.interviewquestion46;

/**
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author yangkuan
 */
public class Solution {
    /**
     * 递归
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int result = 0;
        boolean b = (n==0||(result = Sum_Solution(n-1)+n)>0);
        return result;
    }
}
