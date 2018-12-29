package com.second.chapter2.interviewquestion8;

/**
 *  循环数组中的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author yangkuan
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int midIndex =(left+right)/2;
        while (midIndex!=left){
            if(array[left]==array[midIndex]&&array[right]==array[midIndex]){
                return findMin(array,left,right);
            }
            if(array[midIndex]>=array[left]){
                left = midIndex;
            }
            else if(array[midIndex]<=array[right]){
                right = midIndex;
            }
            midIndex =(left+right)/2;
        }
        return array[right];
    }
    private int findMin(int[] array,int left,int right){
        int min = 0;
        for(int i=left;i<=right;i++){
            min = min<array[i]?min:array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.print(new Solution().minNumberInRotateArray(array));
    }
}
