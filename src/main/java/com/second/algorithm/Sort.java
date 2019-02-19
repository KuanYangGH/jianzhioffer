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
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        for (int n = start; n <= end; n++) {
            nums[n] = tmp[n - start];
        }
    }

    /**
     * 堆排序
     * @param nums
     */
    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        buildMaxHeap(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            swap(nums, 0, nums.length - 1 - i);
            maxHeapify(nums, 0, nums.length - 2 - i);
        }
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, nums.length - 1);
        }
    }

    private void maxHeapify(int[] nums, int start, int end) {
        int i = 2 * start + 1;
        if (i <= end) {
            if (i+1 <= end && nums[i] < nums[i + 1]) i++;
            if (nums[i] > nums[start]) swap(nums, i, start);
            maxHeapify(nums, i, end);
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public void bubbleSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public void insertSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for(int i=1;i<nums.length;i++){
            int tmp = nums[i];
            for(int j=i-1;j>=0;j--){
                if(tmp<nums[j]){
                    swap(nums,j+1,j);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public void selectSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for(int i=0;i<nums.length;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 3, 5, 2};
//        new Sort().quickSort(nums);
//        System.out.println(Arrays.toString(nums));
//        new Sort().mergeSort(nums);
//        System.out.println(Arrays.toString(nums));
//        new Sort().heapSort(nums);
//        System.out.println(Arrays.toString(nums));
//        new Sort().bubbleSort(nums);
//        System.out.println(Arrays.toString(nums));
//        new Sort().insertSort(nums);
//        System.out.println(Arrays.toString(nums));
        new Sort().selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
