package com.second.chapter6.interviewquestion41_1;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array==null||array.length==0){
            return result;
        }
        int beginIndex=0;
        int endIndex = array.length-1;
        while (beginIndex<endIndex){
            if(array[beginIndex]+array[endIndex]>sum){
                endIndex--;
            }
            else if (array[beginIndex]+array[endIndex]<sum){
                beginIndex++;
            }
            else {
                result.add(array[beginIndex]);
                result.add(array[endIndex]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        System.out.println(new Solution().FindNumbersWithSum(array,15));
    }
}
