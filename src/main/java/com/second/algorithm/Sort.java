package com.second.algorithm;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author yangkuan
 */
public class Sort {
    /**
     * 快速排序
     * @param nums
     */
    public void quickSort(int[] nums) {
        quickSortCore(nums,0,nums.length-1);
    }

    private void quickSortCore(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSortCore(nums, start, mid - 1);
            quickSortCore(nums, mid + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int x = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,end);
        return i+1;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,3,5,2};
        new Sort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
