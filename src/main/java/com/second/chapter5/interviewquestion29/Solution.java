package com.second.chapter5.interviewquestion29;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        //特殊情况
        if (array == null || array.length == 0) {
            return 0;
        }
        int value = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            //增加出现次数
            if (array[i] == value) {
                times++;
            }
            //数字不同次数减1，直至0
            else if (array[i] != value && times != 0) {
                times--;
            }
            //重新统计
            else {
                times = 1;
                value = array[i];
            }
        }
        if (isMoreThanHalfNum(array,value))
            return value;
        return 0;
    }

    private boolean isMoreThanHalfNum(int[] array, int value) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                times++;
            }
        }
        if (times * 2 > array.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 3};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }
}
