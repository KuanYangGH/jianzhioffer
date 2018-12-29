package com.second.chapter2.interviewquestion9_2;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author yangkuan
 */
public class Solution {
    public int JumpFloorII(int target) {
        int result = 1;
        for (int i = 2; i <= target; i++) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new Solution().JumpFloorII(4));
    }
}
