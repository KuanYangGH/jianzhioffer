package com.second.chapter2.interviewquestion9;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @author yangkuan
 */
public class Solution {
    public int Fibonacci(int n) {
        int first = 0;
        int second = 1;
        int third = (n == 0 ? 0 : 1);
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.print(new Solution().Fibonacci(3));
    }
}
