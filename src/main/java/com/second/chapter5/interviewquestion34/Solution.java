package com.second.chapter5.interviewquestion34;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author yangkuan
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int flag2 = 0;
        int flag3 = 0;
        int flag5 = 0;
        int nextIndex = 1;
        while (nextIndex < index) {
            uglyNumbers[nextIndex] = min(uglyNumbers[flag2] * 2, uglyNumbers[flag3] * 3, uglyNumbers[flag5] * 5);

            while (uglyNumbers[flag2]*2<=uglyNumbers[nextIndex]){
                flag2++;
            }
            while (uglyNumbers[flag3]*3<=uglyNumbers[nextIndex]){
                flag3++;
            }
            while (uglyNumbers[flag5]*5<=uglyNumbers[nextIndex]){
                flag5++;
            }
            nextIndex++;
        }
        return uglyNumbers[index-1];
    }

    private int min(int a, int b, int c) {
        a = a < b ? a : b;
        return a < c ? a : c;
    }
}
