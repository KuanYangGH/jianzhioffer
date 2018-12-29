package com.second.chapter5.interviewquestion36;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * @author yangkuan
 */
public class Solution {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return InversePairs(array, 0, array.length - 1);
    }

    private int InversePairs(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 0;
        }
        int cnt = 0;
        int midIndex = (startIndex + endIndex) / 2;
        cnt += InversePairs(array, startIndex, midIndex);
        cnt += InversePairs(array, midIndex + 1, endIndex);
        cnt += merge(array, startIndex, endIndex);
        return cnt % 1000000007;
    }

    private int merge(int[] array, int startIndex, int endIndex) {
        int cnt = 0;
        int[] copy = Arrays.copyOfRange(array, startIndex, endIndex + 1);
        int midIndex = (endIndex + startIndex) / 2;
        int i = midIndex, j = endIndex;
        int k = endIndex;
        while (i >= startIndex && j > midIndex) {
            if (copy[i - startIndex] > copy[j - startIndex]) {
                cnt = (cnt + j - midIndex) % 1000000007;
                array[k] = copy[i - startIndex];
                i--;
            } else {
                array[k] = copy[j - startIndex];
                j--;
            }
            k--;
        }
        while (i >= startIndex) {
            array[k] = copy[i - startIndex];
            k--;
            i--;
        }
        while (j > midIndex) {
            array[k] = copy[j - startIndex];
            k--;
            j--;
        }
        return cnt % 1000000007;
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        int cnt = new Solution().InversePairs(array);
        System.out.println(Arrays.toString(array));
        System.out.println(cnt);
    }
}
