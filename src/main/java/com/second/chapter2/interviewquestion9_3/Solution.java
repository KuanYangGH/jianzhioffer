package com.second.chapter2.interviewquestion9_3;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author yangkuan
 */
public class Solution {
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        int first = 1;
        int second = 2;
        int third = target == 1 ? first : second;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
