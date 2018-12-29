package com.second.chapter3.interviewquestion14;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author yangkuan
 */
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] newArray = Arrays.copyOfRange(array, 0, array.length);
        int j = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (!isEven(newArray[i])) {
                array[j] = newArray[i];
                j++;
            }
        }
        for (int i = 0; i < newArray.length; i++) {
            if (isEven(newArray[i])) {
                array[j] = newArray[i];
                j++;
            }
        }
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}
