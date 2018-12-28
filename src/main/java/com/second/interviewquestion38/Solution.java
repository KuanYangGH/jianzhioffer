package com.second.interviewquestion38;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstIndex = getFirstK(array, k, 0, array.length - 1);
        int lastIndex = getLastK(array, k, 0, array.length - 1);
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }
        return lastIndex - firstIndex + 1;
    }

    private int getFirstK(int[] array, int k, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return -1;
        }
        int mid = (beginIndex + endIndex) / 2;
        int index = -1;
        if (array[mid] > k) {
            index = getFirstK(array, k, beginIndex, mid - 1);
        } else if (array[mid] < k) {
            index = getFirstK(array, k, mid + 1, endIndex);
        } else {
            if (mid == 0 || array[mid - 1] != k) {
                index = mid;
            } else {
                index = getFirstK(array, k, beginIndex, mid - 1);
            }
        }
        return index;
    }

    private int getLastK(int[] array, int k, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return -1;
        }
        int mid = (beginIndex + endIndex) / 2;
        int index = -1;
        if (array[mid] > k) {
            index = getLastK(array, k, beginIndex, mid - 1);
        } else if (array[mid] < k) {
            index = getLastK(array, k, mid + 1, endIndex);
        } else {
            if (mid == array.length - 1 || array[mid + 1] != k) {
                index = mid;
            } else {
                index = getLastK(array, k, mid + 1, endIndex);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4};
        System.out.println(new Solution().GetNumberOfK(array, 5));
    }
}
