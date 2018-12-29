package com.second.chapter2.interviewquestion9_1;


/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * f(n)=f(n-1)+f(n-2)
 *
 * @author yangkuan
 */
public class Solution {
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        }
        int first = 1;
        int second = 2;
        int third = (target == 1 ? first : second);
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.print(new Solution().JumpFloor(3));
    }
}
