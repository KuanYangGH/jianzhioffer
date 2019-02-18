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
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        quickSortCore(nums, 0, nums.length - 1);
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
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 归并排序
     *
     * @param nums
     */
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        mergeSortCore(nums, 0, nums.length - 1);
    }

    private void mergeSortCore(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortCore(nums, start, mid);
        mergeSortCore(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            }
            else {
                tmp[k++] = nums[j++];
            }
        }
        while (i<=mid){
            tmp[k++] = nums[i++];
        }
        while (j<=end){
            tmp[k++] = nums[j++];
        }
        for(int n=start;n<=end;n++){
            nums[n]=tmp[n-start];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 3, 5, 2};
        new Sort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
        new Sort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
