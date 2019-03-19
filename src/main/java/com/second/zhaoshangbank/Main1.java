package com.second.zhaoshangbank;

import java.util.Scanner;

/**
 *
 * @author yangkuan
 * @date 2019/03/17
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        getMax(nums);
        System.out.println(max);
    }
    static int  max = Integer.MIN_VALUE;
    private static void getMax(int[] nums){
        if(nums.length==1){
            max = Math.max(max,nums[0]);
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                getMax(newArray(nums,i,i+1));
            }
            else if(i==nums.length-1){
                getMax(newArray(nums,i,i-1));
            }
            else {
                getMax(newArray(nums,i,i-1));
                getMax(newArray(nums,i,i+1));
            }
        }
    }
    private static int[] newArray(int[] nums,int i,int j){
        int[] newNums = new int[nums.length-1];
        int cnt = 0;
        for(int k=0;k<nums.length;k++){
            if(k!=i&&k!=j){
                newNums[cnt++] = nums[k];
            }
            else if(k==j){
                newNums[cnt++] = nums[j]-nums[i];
            }
        }
        return newNums;
    }
}
