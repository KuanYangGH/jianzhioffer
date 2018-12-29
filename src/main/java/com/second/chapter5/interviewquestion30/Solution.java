package com.second.chapter5.interviewquestion30;


import java.util.ArrayList;
import java.util.Random;

/**
 * 最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return result;
        }
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k-1) {
            if (index < k-1) {
                start = index + 1;
                index = partition(input, start, end);
            } else {
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int partition(int[] input, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(input, index, end);
        int x = input[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (input[j] <= x) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, end);
        return i + 1;
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new Solution().GetLeastNumbers_Solution(input, 8));
    }
}
